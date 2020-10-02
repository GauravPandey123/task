package com.swipewcards.áctivity

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.swipewcards.R
import com.swipewcards.adapter.FavoirteAdapter
import com.swipewcards.model.StackHolder
import com.swipewcards.sessionManager
import kotlinx.android.synthetic.main.favorite_layout.*
import java.lang.reflect.Type


class FaviortesActivity : AppCompatActivity() {

    private lateinit var favoirteAdapter: FavoirteAdapter
    private lateinit var arrayListFaviotre: ArrayList<StackHolder>
    private lateinit var name: String
    private lateinit var location: String
    private lateinit var url: String
    private lateinit var nam: ArrayList<StackHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.favorite_layout)
        setUpElements()

    }

    private fun setUpElements() {
        arrayListFaviotre = ArrayList()
        val intent = intent
        val extras = intent.extras


        val adapter = FavoirteAdapter(this, getArrayList("shrd"))
        recylervieeFaviorte.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recylervieeFaviorte.adapter = adapter


    }

    fun getArrayList(key: String?): ArrayList<StackHolder> {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val gson = Gson()
        val json = prefs.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<StackHolder?>?>() {}.type
        return gson.fromJson(json, type)
    }

    private fun createSpot(): StackHolder {
        return StackHolder(
            name = "Gaurav Pandey",
            city = "Delhi",
            url = "https://source.unsplash.com/Xq1ntWruZQI/600x800"
        )
    }

    private fun createSpots(): List<StackHolder> {
        val spots = java.util.ArrayList<StackHolder>()
        spots.add(
            StackHolder(
                name = sessionManager.name.toString(),
                city = sessionManager.city.toString(),
                url = sessionManager.image.toString()
            )
        )

        return spots
    }
}