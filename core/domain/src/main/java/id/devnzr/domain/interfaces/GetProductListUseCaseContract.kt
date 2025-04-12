package id.devnzr.domain.interfaces

import id.devnzr.data.utils.ResultState
import id.devnzr.domain.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetProductListUseCaseContract {
    operator fun invoke(): Flow<ResultState<List<ProductEntity>>>
}