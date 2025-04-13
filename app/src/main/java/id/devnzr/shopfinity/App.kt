package id.devnzr.shopfinity

import android.app.Application
import android.content.Context
import id.devnzr.data.di.dataSourceModule
import id.devnzr.data.di.repositoryModule
import id.devnzr.database.di.databaseModule
import id.devnzr.datastore.di.dataStoreModule
import id.devnzr.domain.di.useCaseModule
import id.devnzr.network.di.networkModule
import id.devnzr.shopfinity.account.di.accountViewModelModule
import id.devnzr.shopfinity.carts.di.cartsViewModelModule
import id.devnzr.shopfinity.home.di.homeViewModelModule
import id.devnzr.shopfinity.login.di.loginViewModelModule
import id.devnzr.shopfinity.splash.di.splashViewModelModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                single<Context> { this@App }
            }
        )
    }

    private fun initKoin(appModule: Module) = startKoin {
        modules(
            appModule,
            databaseModule,
            dataStoreModule,
            dataSourceModule,
            networkModule,
            repositoryModule,
            useCaseModule,
            homeViewModelModule,
            accountViewModelModule,
            loginViewModelModule,
            splashViewModelModule,
            cartsViewModelModule
        )
    }
}
