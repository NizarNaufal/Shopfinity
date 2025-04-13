package id.devnzr.datastore.di

import android.content.Context
import id.devnzr.datastore.DataStoreManager
import id.devnzr.datastore.serializer.userPreferencesDataStore
import org.koin.dsl.module

val dataStoreModule = module {
    single { provideUserPreferenceManager(get()) }
}

fun provideUserPreferenceManager(context: Context): DataStoreManager {
    return DataStoreManager(context.userPreferencesDataStore)
}
