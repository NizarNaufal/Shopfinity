package id.devnzr.domain.interfaces

import id.devnzr.domain.utils.ResultState
import id.devnzr.domain.models.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetProductListUseCase {
    operator fun invoke(): Flow<ResultState<List<ProductEntity>>>
}