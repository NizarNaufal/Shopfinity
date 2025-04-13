package id.devnzr.database.di

import androidx.room.Room
import id.devnzr.database.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "cart_database"
        ).fallbackToDestructiveMigration().build()
    }

    single { get<AppDatabase>().cartDao() }
}
