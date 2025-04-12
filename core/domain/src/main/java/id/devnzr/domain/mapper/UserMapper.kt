package id.devnzr.domain.mapper

import id.devnzr.data.entities.UserSourceApi
import id.devnzr.domain.entities.UserEntity

fun UserSourceApi.map(): UserEntity {
    return UserEntity(
        id = this.id ?: 0,
        username = this.username ?: "",
        email = this.email ?: "",
        password = this.password ?: "",
    )
}