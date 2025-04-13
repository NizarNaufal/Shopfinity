package id.devnzr.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(
    private val dataStore: DataStore<UserPreferences>
) {
    val token: Flow<String> = dataStore.data.map { it.token }

    suspend fun saveToken(token: String) {
        dataStore.updateData { prefs ->
            prefs.toBuilder().setToken(token).build()
        }
    }

    suspend fun clearToken() {
        dataStore.updateData { prefs ->
            prefs.toBuilder().clearToken().build()
        }
    }
}