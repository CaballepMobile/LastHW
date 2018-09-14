package com.example.admin.week7final.di.module

import com.example.admin.week7final.helper.Constants.NumberRESTConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [OkHttpModule::class])
class RetrofitModule {

    @Provides
    internal fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(NumberRESTConstants.BaseUrl)
                .build()
    }
}
