package id.devnzr.domain.interfaces

import id.devnzr.domain.utils.ResultState
import id.devnzr.domain.entities.AllCartsEntity
import kotlinx.coroutines.flow.Flow

interface GetAllCartsUseCaseContract {
    operator fun invoke(): Flow<ResultState<List<AllCartsEntity>>>
}