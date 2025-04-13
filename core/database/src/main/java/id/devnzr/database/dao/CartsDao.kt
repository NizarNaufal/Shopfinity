package id.devnzr.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import id.devnzr.database.entities.CartWithProducts
import id.devnzr.database.entities.CartsEntity
import id.devnzr.database.entities.ProductsEntity

@Dao
interface CartDao {

    @Transaction
    @Query("SELECT * FROM carts")
    suspend fun getAllCartsWithProducts(): List<CartWithProducts>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCart(cart: CartsEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductsEntity>)

    @Delete
    suspend fun deleteCart(cart: CartsEntity)
}
