package com.swipewcards.networkservice

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitService {
    companion object {
        private const val BASE_URL = "https://randomuser.me/api/0.4/"
    }

    private fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(HeaderIntercepter())
            .readTimeout(2, TimeUnit.MINUTES).writeTimeout(2, TimeUnit.MINUTES).build()
    }


    class HeaderIntercepter : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response = chain.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Appversion", "1.0")
                    .addHeader("Ostype", "Android")
                    .build()
            )
        }
    }


    fun getServiceApi(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    fun getRetrofit(baseurl: String) = Retrofit.Builder()
        .baseUrl(baseurl)
        .client(getClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val offlineRechage: ApiService = getServiceApi(getRetrofit(BASE_URL))


}
