package id.devnzr.data.di

import id.devnzr.data.api.AuthApi
import id.devnzr.data.api.CartsApi
import id.devnzr.data.api.ProductApi
import id.devnzr.data.interfaces.AuthRepositoryContract
import id.devnzr.data.interfaces.CartsRepositoryContract
import id.devnzr.data.interfaces.ProductRepositoryContract
import id.devnzr.data.repository.AuthRepository
import id.devnzr.data.repository.CartsRepository
import id.devnzr.data.repository.ProductRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val dataSourceModule = module {
    single {
        get<Retrofit>(named("BaseClient")).create(ProductApi::class.java)
    }
    single {
        get<Retrofit>(named("BaseClient")).create(CartsApi::class.java)
    }
    single {
        get<Retrofit>(named("BaseClient")).create(AuthApi::class.java)
    }
}

val repositoryModule = module {
    single<ProductRepositoryContract> {
        ProductRepository(get())
    }
    single<CartsRepositoryContract> {
        CartsRepository(get())
    }
    single<AuthRepositoryContract> {
        AuthRepository(get())
    }
}