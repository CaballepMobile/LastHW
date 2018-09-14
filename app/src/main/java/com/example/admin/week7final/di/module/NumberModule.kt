package com.example.admin.week7final.di.module

import com.example.admin.week7final.model.network.NumberService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
object NumberModule {

    @Provides
    fun getNumberService(retrofit: Retrofit) : NumberService {
        return retrofit.create(NumberService::class.java)
    }
}
