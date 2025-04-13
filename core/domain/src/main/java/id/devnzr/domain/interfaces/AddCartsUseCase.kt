package id.devnzr.domain.interfaces

import id.devnzr.domain.models.AllCartsEntity

interface AddCartsUseCase {
    suspend operator fun invoke(cart: AllCartsEntity): List<AllCartsEntity>
}
