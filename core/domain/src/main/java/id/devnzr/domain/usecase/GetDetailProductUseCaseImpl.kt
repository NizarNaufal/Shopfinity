package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.ProductRepository
import id.devnzr.domain.interfaces.GetDetailProductUseCase
import id.devnzr.domain.mapper.map
import id.devnzr.domain.mapper.responseErrorToResultStateError
import id.devnzr.domain.models.ProductEntity
import id.devnzr.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetDetailProductUseCaseImpl(
    private val productRepository: ProductRepository
) : GetDetailProductUseCase {

    override fun invoke(id: String): Flow<ResultState<ProductEntity>> = flow {
        runCatching {
            productRepository.fetchDetailProduct(id)
        }.onSuccess { products ->
            emit(ResultState.Success(data = products.map()))
        }.onFailure {
            emit(responseErrorToResultStateError(it))
        }
    }
}
