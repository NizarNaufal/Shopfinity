package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.ProductRepository
import id.devnzr.domain.interfaces.GetProductListUseCase
import id.devnzr.domain.mapper.mapProducts
import id.devnzr.domain.mapper.responseErrorToResultStateError
import id.devnzr.domain.models.ProductEntity
import id.devnzr.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetProductListUseCaseImpl(
    private val productRepository: ProductRepository
) : GetProductListUseCase {

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
