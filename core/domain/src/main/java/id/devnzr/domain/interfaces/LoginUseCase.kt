package id.devnzr.domain.interfaces

import id.devnzr.domain.models.LoginResult
import id.devnzr.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    operator fun invoke(
        username: String,
        password: String,
    ): Flow<ResultState<LoginResult>>
}