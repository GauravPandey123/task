package com.swipewcards.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swipewcards.networkservice.ApiResponse
import com.swipewcards.repository.UserDeatilsRepository

class ProfilesViewModel(application: Application) : AndroidViewModel(application){

    private val userDetailRepository: UserDeatilsRepository by lazy {
        UserDeatilsRepository()
    }

    fun getUserData(): MutableLiveData<ApiResponse> {
        return userDetailRepository.getUpComingBill()
    }}