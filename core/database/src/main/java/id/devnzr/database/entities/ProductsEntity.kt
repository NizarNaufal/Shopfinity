package id.devnzr.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "products",
    foreignKeys = [
        ForeignKey(
            entity = CartsEntity::class,
            parentColumns = ["id"],
            childColumns = ["cartId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["cartId"])]
)
data class ProductsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cartId: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String
)
