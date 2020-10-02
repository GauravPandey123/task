package com.swipewcards.áctivity

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.swipewcards.R
import com.swipewcards.model.ResultsItem
import com.swipewcards.model.UserResponse
import com.swipewcards.utils.isOnline
import com.swipewcards.utils.showSnackbar
import com.swipewcards.viewmodel.ProfilesViewModel
import kotlinx.android.synthetic.main.user_details_layout.*


class DeatilsActivity : AppCompatActivity() {

    private val detailViewModel: ProfilesViewModel by lazy {
        ViewModelProvider(this).get(ProfilesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_details_layout)
        isOnline().let {
            if (it) {
                setUpElements()
            } else {
                nestedscrollviewRecharge.showSnackbar(
                    resources.getString(R.string.pleasecheckinternet),
                    Snackbar.LENGTH_SHORT
                )
            }
        }

    }

    private fun setUpElements() {

        detailViewModel.getUserData().observe(this, Observer {
            val response = it.response as UserResponse
            if (response.results != null) {
                contatinProgresBarDashBoard.visibility = View.GONE
                setUpServiceDate(response.results)
                nestedscrollviewRecharge.showSnackbar(
                    "Data Fetched Successfully",
                    Snackbar.LENGTH_LONG
                )
            } else {
                contatinProgresBarDashBoard.visibility = View.GONE
                nestedscrollviewRecharge.showSnackbar(
                    "Failure",
                    Snackbar.LENGTH_LONG
                )
            }
        })


    }

    private fun setUpServiceDate(results: List<ResultsItem?>) {
        Glide.with(this)
            .load("https://api.randomuser.me/portraits/women/8.jpg").circleCrop()
            .into(user_profile_photo)

        user_profile_name.text = "Name : " +results[0]?.user?.name?.title +" "+results[0]?.user?.name?.first + " "+results[0]?.user?.name?.last
        user_profile_short_bio.text="Email" +results[0]?.user?.email.toString()
        textView.text="Phone No : "+results[0]?.user?.phone.toString()
        location.text = "State : " +results[0]?.user?.location?.state  +" "+"Zipcode" +results[0]?.user?.location?.zip+ " "+"City"  + results[0]?.user?.location?.city
        gender .text = "Gender : " +results[0]?.user?.gender
        dob.text ="Date Of Birth : " +results[0]?.user?.dob

    }
}