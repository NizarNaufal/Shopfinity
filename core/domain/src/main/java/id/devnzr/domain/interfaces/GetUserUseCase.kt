package id.devnzr.domain.interfaces

import id.devnzr.domain.utils.ResultState
import id.devnzr.domain.models.UserEntity
import kotlinx.coroutines.flow.Flow

interface GetUserUseCase {
    operator fun invoke(id: String): Flow<ResultState<UserEntity>>
}