package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.AuthRepositoryContract
import id.devnzr.data.models.request.LoginRequest
import id.devnzr.domain.models.LoginResult
import id.devnzr.domain.interfaces.LoginUseCase
import id.devnzr.domain.mapper.map
import id.devnzr.domain.mapper.responseErrorToResultStateError
import id.devnzr.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCaseImpl(
    private val authRepository: AuthRepositoryContract
) : LoginUseCase {
    override fun invoke(
        username: String,
        password: String
    ): Flow<ResultState<LoginResult>> = flow {
        emit(ResultState.Loading())
        runCatching {
            authRepository.login(LoginRequest(username, password))
        }.onSuccess { products ->
            emit(ResultState.Success(data = products.map()))
        }.onFailure { throwable ->
            emit(responseErrorToResultStateError(throwable))
        }
    }
}
