package id.devnzr.domain.usecase

import id.devnzr.data.interfaces.AuthRepositoryContract
import id.devnzr.domain.utils.ResultState
import id.devnzr.domain.entities.UserEntity
import id.devnzr.domain.interfaces.GetUserUseCaseContract
import id.devnzr.domain.mapper.map
import id.devnzr.domain.mapper.responseErrorToResultStateError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUserUseCase(
    private val userRepository: AuthRepositoryContract
) : GetUserUseCaseContract {

    override fun invoke(id: String): Flow<ResultState<UserEntity>> = flow {
        emit(ResultState.Loading())
        runCatching {
            userRepository.fetchUser(id = id)
        }.onSuccess { products ->
            emit(ResultState.Success(data = products.map()))
        }.onFailure { throwable ->
            emit(responseErrorToResultStateError(throwable))
        }
    }
}
