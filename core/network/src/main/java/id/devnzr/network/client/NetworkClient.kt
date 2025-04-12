package id.devnzr.network.client

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import okhttp3.OkHttpClient
import id.devnzr.network.BuildConfig
import id.devnzr.network.ext.RetrofitClient

fun getHttpClient(application: Context): OkHttpClient {
    val chuckerInterceptor = ChuckerInterceptor.Builder(application).collector(
        ChuckerCollector(
            context = application,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
    ).maxContentLength(250_000L).redactHeaders("Auth-Token", "Bearer")
        .alwaysReadResponseBody(true).build()

    val okHttpClient = RetrofitClient.okHttpClientBuilder()

    if (BuildConfig.BUILD_TYPE == "debug") {
        okHttpClient.addInterceptor(RetrofitClient.provideHttpLoggingInterceptor())
        okHttpClient.addInterceptor(chuckerInterceptor)
    }

    return okHttpClient.build()
}