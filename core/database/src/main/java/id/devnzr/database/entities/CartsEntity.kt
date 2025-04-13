package id.devnzr.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carts")
data class CartsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: String
)
