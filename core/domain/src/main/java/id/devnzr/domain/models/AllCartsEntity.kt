package id.devnzr.domain.models

data class AllCartsEntity(
    val id: Int?,
    val userId: String?,
    val products: List<ProductEntity>
)
