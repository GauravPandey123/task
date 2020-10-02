package com.swipewcards.networkservice

import com.swipewcards.model.UserResponse
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("?randomapi")
    fun getData() : Call<UserResponse>
}