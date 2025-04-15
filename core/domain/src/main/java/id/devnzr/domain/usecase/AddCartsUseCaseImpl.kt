package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.CartsRepository
import id.devnzr.data.models.Carts
import id.devnzr.data.models.Products
import id.devnzr.domain.interfaces.AddCartsUseCase
import id.devnzr.domain.mapper.mapProducts
import id.devnzr.domain.models.AllCartsEntity

class AddCartsUseCaseImpl(
    private val repository: CartsRepository
) : AddCartsUseCase {

    override suspend fun invoke(cart: AllCartsEntity): List<AllCartsEntity> {
        val domainModel = Carts(
            id = cart.id,
            userId = cart.userId,
            products = cart.products.map {
                Products(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    description = it.description,
                    category = it.category,
                    image = it.image
                )
            }
        )
        return repository.addCart(domainModel).map {
            AllCartsEntity(
                id = it.id,
                userId = it.userId,
                products = it.products.mapProducts()
            )
        }
    }
}
