package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.ProductRepositoryContract
import id.devnzr.data.utils.ResultState
import id.devnzr.domain.entities.ProductEntity
import id.devnzr.domain.interfaces.GetProductListUseCaseContract
import id.devnzr.domain.mapper.mapProducts
import id.devnzr.domain.mapper.responseErrorToResultStateError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetProductListUseCase(
    private val productRepository: ProductRepositoryContract
) : GetProductListUseCaseContract {

    override fun invoke(): Flow<ResultState<List<ProductEntity>>> = flow {
        emit(ResultState.Loading())
        runCatching {
            productRepository.fetchProductList()
        }.onSuccess { products ->
            emit(ResultState.Success(data = products.mapProducts()))
        }.onFailure { throwable ->
            emit(responseErrorToResultStateError(throwable))
        }
    }
}
