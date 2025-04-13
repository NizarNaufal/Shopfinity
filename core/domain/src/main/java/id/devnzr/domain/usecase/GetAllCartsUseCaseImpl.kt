package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.CartsRepositoryContract
import id.devnzr.domain.interfaces.GetAllCartsUseCase
import id.devnzr.domain.mapper.mapCarts
import id.devnzr.domain.models.AllCartsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllCartsUseCaseImpl(
    private val cartsRepository: CartsRepositoryContract
) : GetAllCartsUseCase {

    override fun invoke(): Flow<List<AllCartsEntity>> = flow {
        runCatching {
            cartsRepository.fetchAllCarts()
        }.onSuccess { products ->
            emit(products.mapCarts())
        }
    }
}
