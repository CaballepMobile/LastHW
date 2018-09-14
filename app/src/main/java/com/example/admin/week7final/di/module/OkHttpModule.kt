package com.example.admin.week7final.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
class OkHttpModule {

    /*
    val okHttpClient: OkHttpClient

        @Provides
        get() = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .build()
    */

    @Provides
    internal fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {

        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }
}
