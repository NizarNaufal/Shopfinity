package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.CartsRepositoryContract
import id.devnzr.data.models.Carts
import id.devnzr.data.models.Products
import id.devnzr.domain.interfaces.AddCartsUseCase
import id.devnzr.domain.models.AllCartsEntity
import id.devnzr.domain.models.ProductEntity

class AddCartsUseCaseImpl(
    private val repository: CartsRepositoryContract
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
                products = it.products.map { p ->
                    ProductEntity(
                        id = p.id,
                        title = p.title,
                        price = p.price,
                        description = p.description,
                        category = p.category,
                        image = p.image
                    )
                }
            )
        }
    }
}
