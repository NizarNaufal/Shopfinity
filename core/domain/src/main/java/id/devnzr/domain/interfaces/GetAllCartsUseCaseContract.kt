package id.devnzr.domain.interfaces

import id.devnzr.domain.utils.ResultState
import id.devnzr.domain.models.AllCartsEntity
import kotlinx.coroutines.flow.Flow

interface GetAllCartsUseCaseContract {
    operator fun invoke(): Flow<ResultState<List<AllCartsEntity>>>
}