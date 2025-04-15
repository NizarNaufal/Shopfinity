package id.devnzr.data.repository

import id.devnzr.data.interfaces.CartsRepository
import id.devnzr.data.models.Carts
import id.devnzr.data.models.Products
import id.devnzr.database.dao.CartDao
import id.devnzr.database.entities.CartsEntity
import id.devnzr.database.entities.ProductsEntity

class CartsRepositoryImpl(
    private val cartDao: CartDao
) : CartsRepository {

    override suspend fun fetchAllCarts(): List<Carts> {
        val cartsWithProducts = cartDao.getAllCartsWithProducts()
        return cartsWithProducts.map { cartWithProducts ->
            Carts(
                id = cartWithProducts.cart.id,
                userId = cartWithProducts.cart.userId,
                products = cartWithProducts.products.map { product ->
                    Products(
                        id = product.id,
                        title = product.title,
                        price = product.price,
                        description = product.description,
                        category = product.category,
                        image = product.image
                    )
                }
            )
        }
    }

    override suspend fun addCart(body: Carts): List<Carts> {
        val cartEntity = CartsEntity(userId = body.userId.orEmpty())
        val cartId = cartDao.insertCart(cartEntity).toInt()
        val productEntities = body.products.map { product ->
            ProductsEntity(
                cartId = cartId,
                title = product.title.orEmpty(),
                price = product.price ?: 0.0,
                description = product.description.orEmpty(),
                category = product.category.orEmpty(),
                image = product.image.orEmpty()
            )
        }
        cartDao.insertProducts(productEntities)
        return fetchAllCarts()
    }
}

