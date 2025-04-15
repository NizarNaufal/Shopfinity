package id.devnzr.data.di

import id.devnzr.data.api.AuthApi
import id.devnzr.data.api.ProductApi
import id.devnzr.data.interfaces.AuthRepository
import id.devnzr.data.interfaces.CartsRepository
import id.devnzr.data.interfaces.ProductRepository
import id.devnzr.data.repository.AuthRepositoryImpl
import id.devnzr.data.repository.CartsRepositoryImpl
import id.devnzr.data.repository.ProductRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val dataSourceModule = module {
    single {
        get<Retrofit>(named("BaseClient")).create(ProductApi::class.java)
    }
    single {
        get<Retrofit>(named("BaseClient")).create(AuthApi::class.java)
    }
}

val repositoryModule = module {
    single<ProductRepository> {
        ProductRepositoryImpl(get())
    }
    single<CartsRepository> {
        CartsRepositoryImpl(get())
    }
    single<AuthRepository> {
        AuthRepositoryImpl(get(), get())
    }
}
