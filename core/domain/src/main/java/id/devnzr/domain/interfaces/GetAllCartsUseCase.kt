package id.devnzr.domain.interfaces

import id.devnzr.domain.models.AllCartsEntity
import kotlinx.coroutines.flow.Flow

interface GetAllCartsUseCase {
    operator fun invoke(): Flow<List<AllCartsEntity>>
}
