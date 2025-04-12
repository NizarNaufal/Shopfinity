package id.devnzr.domain.entities

data class AllCartsEntity(
    val id: Int?,
    val userId: String?,
    val products: List<ProductEntity>
)