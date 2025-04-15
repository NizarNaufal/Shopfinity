package id.devnzr.domain.interfaces

import id.devnzr.domain.models.ProductEntity
import id.devnzr.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface GetDetailProductUseCase {
    operator fun invoke(id: String): Flow<ResultState<ProductEntity>>
}
