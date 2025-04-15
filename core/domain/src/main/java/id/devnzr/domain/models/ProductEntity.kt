package id.devnzr.domain.models

data class ProductEntity(
    val id: Int = 0,
    val title: String = "",
    val price: Double = 0.0,
    val description: String = "",
    val category: String = "",
    val image: String = "",
    val quantity: Int = 1
)
