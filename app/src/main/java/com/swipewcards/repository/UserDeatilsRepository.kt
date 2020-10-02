package com.swipewcards.repository

import androidx.lifecycle.MutableLiveData
import com.swipewcards.datasource.getDashBoardServiceData
import com.swipewcards.datasource.onError
import com.swipewcards.datasource.onSuccess
import com.swipewcards.model.UserResponse
import com.swipewcards.networkservice.ApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDeatilsRepository {

    fun getUpComingBill(): MutableLiveData<ApiResponse> {
        val result = MutableLiveData<ApiResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val requets = getDashBoardServiceData()
            requets.onSuccess {
                it.results.let { _ -> }
                result.postValue(ApiResponse(it, null))
            }
            requets.onError {
                result.postValue(ApiResponse(null, it))

            }
        }
        return result
    }



}