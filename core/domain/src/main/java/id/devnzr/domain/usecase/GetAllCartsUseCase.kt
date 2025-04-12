package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.CartsRepositoryContract
import id.devnzr.data.utils.ResultState
import id.devnzr.domain.entities.AllCartsEntity
import id.devnzr.domain.interfaces.GetAllCartsUseCaseContract
import id.devnzr.domain.mapper.mapCarts
import id.devnzr.domain.mapper.responseErrorToResultStateError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllCartsUseCase(
    private val cartsRepository: CartsRepositoryContract
) : GetAllCartsUseCaseContract {

    override fun invoke(): Flow<ResultState<List<AllCartsEntity>>> = flow {
        emit(ResultState.Loading())
        runCatching {
            cartsRepository.fetchAllCarts()
        }.onSuccess { products ->
            emit(ResultState.Success(data = products.mapCarts()))
        }.onFailure { throwable ->
            emit(responseErrorToResultStateError(throwable))
        }
    }
}
