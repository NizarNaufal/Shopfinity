package id.devnzr.domain.interfaces

import id.devnzr.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface GetTokenUseCase {
    operator fun invoke(): Flow<ResultState<String>>
}