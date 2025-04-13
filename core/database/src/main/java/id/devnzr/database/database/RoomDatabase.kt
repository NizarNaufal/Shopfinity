package id.devnzr.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import id.devnzr.database.dao.CartDao
import id.devnzr.database.entities.CartsEntity
import id.devnzr.database.entities.ProductsEntity

@Database(
    entities = [CartsEntity::class, ProductsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}
