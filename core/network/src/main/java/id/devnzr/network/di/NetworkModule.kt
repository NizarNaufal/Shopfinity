package id.devnzr.network.di

import id.devnzr.network.BuildConfig
import id.devnzr.network.client.getHttpClient
import id.devnzr.network.ext.RetrofitClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("BaseClient")) {
        RetrofitClient.create(
            baseUrl = BuildConfig.BASE_URL, okHttpClient = getHttpClient(get())
        )
    }
}

