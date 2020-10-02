package com.swipewcards.datasource

import com.swipewcards.model.UserResponse
import com.swipewcards.networkservice.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import com.swipewcards.utils.Result
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

suspend fun <T : Any> Call<T>.getResult(): Result<T> = suspendCoroutine {
    this.enqueue(object : Callback<T> {

        override fun onFailure(call: Call<T>?, error: Throwable?) =
            it.resume(Result.Error(error))

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            if (response?.body() != null) {
                it.resume(Result.Success(response.body()!!))
            } else {
                it.resume(Result.Error(Throwable("INTERNAL SERVER ERROR")))
            }
        }
    })
}

inline fun <T : Any> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Result.Success) action(data)

    return this
}

inline fun <T : Any> Result<T>.onError(action: (Throwable) -> Unit) {
    if (this is Result.Error && error != null) action(error)
}


suspend fun getDashBoardServiceData(): Result<UserResponse> = GlobalScope.async {
    return@async RetrofitService().offlineRechage.getData().getResult()
}.await()