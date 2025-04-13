package id.devnzr.domain.mapper

import id.devnzr.data.models.response.LoginResponse
import id.devnzr.data.models.response.UserResponse
import id.devnzr.domain.models.LoginResult
import id.devnzr.domain.models.UserEntity

fun UserResponse.map(): UserEntity {
    return UserEntity(
        id = this.id ?: 0,
        username = this.username ?: "",
        email = this.email ?: "",
        password = this.password ?: "",
    )
}

fun LoginResponse.map(): LoginResult {
    return LoginResult(
        token = this.token ?: "",
    )
}