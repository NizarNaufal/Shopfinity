package id.devnzr.data.di

import id.devnzr.data.api.ProductApi
import id.devnzr.data.interfaces.ProductRepositoryContract
import id.devnzr.data.repository.ProductRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val dataSourceModule = module {
    single {
        get<Retrofit>(named("BaseClient")).create(ProductApi::class.java)
    }
}

val repositoryModule = module {
    single<ProductRepositoryContract> {
        ProductRepository(get())
    }
}