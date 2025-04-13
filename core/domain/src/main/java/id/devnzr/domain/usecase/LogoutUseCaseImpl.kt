package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.AuthRepositoryContract
import id.devnzr.domain.interfaces.LogoutUseCase
import id.devnzr.domain.mapper.responseErrorToResultStateError
import id.devnzr.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LogoutUseCaseImpl(
    private val authRepository: AuthRepositoryContract
) : LogoutUseCase {
    override fun invoke(): Flow<ResultState<String>> = flow {
        emit(ResultState.Loading())
        runCatching {
            authRepository.deleteToken()
        }.onSuccess {
            emit(ResultState.Success(data = ""))
        }.onFailure { throwable ->
            emit(responseErrorToResultStateError(throwable))
        }
    }
}
