package id.devnzr.domain.interfaces

import id.devnzr.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface LogoutUseCase {
    operator fun invoke(): Flow<ResultState<String>>
}
