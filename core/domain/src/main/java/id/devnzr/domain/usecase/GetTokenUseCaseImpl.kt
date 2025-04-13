package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.AuthRepository
import id.devnzr.domain.interfaces.GetTokenUseCase
import id.devnzr.domain.mapper.responseErrorToResultStateError
import id.devnzr.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTokenUseCaseImpl(private val authRepository: AuthRepository) : GetTokenUseCase {
    override fun invoke(): Flow<ResultState<String>> = flow {
        emit(ResultState.Loading())
        runCatching {
            authRepository.checkToken()
        }.onSuccess { token ->
            if (token.isNotEmpty()) {
                emit(ResultState.Success(data = token))
            } else {
                emit(ResultState.Error(code = 0, message = "Token is empty"))
            }
        }.onFailure { throwable ->
            emit(responseErrorToResultStateError(throwable))
        }
    }
}
