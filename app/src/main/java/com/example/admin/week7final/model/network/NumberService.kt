package com.example.admin.week7final.model.network

import com.example.admin.week7final.model.networkPojo.NumberResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface NumberService {
    //Example: jsonI.php?length=40&type=uint8
    @GET("API/jsonI.php")
    fun getNumbers(@Query("length") length: String, @Query("type") type: String):
            Single<NumberResponse>
}
