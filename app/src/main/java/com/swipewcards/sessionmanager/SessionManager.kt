package com.swipewcards.sessionmanager

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.swipewcards.model.StackHolder

class SessionManager(context: Context) {

    companion object {
        private const val USER_PREF = "user_pref"
        private const val NAME = "Name"
        private const val City = "City"
        private const val ImageUrl = "Url"
        private const val favdata = "FavData"

    }

    private val pref: SharedPreferences =
        context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)





    fun saveMessages(context: Context?,messageObjects:ArrayList<StackHolder>)
    {
        val gson=Gson()
        context?.getSharedPreferences(favdata,Context.MODE_PRIVATE)?.edit()?.putString(favdata,gson.toJson(messageObjects))?.apply()
    }

    //get messages
    fun getMessages(context: Context?):ArrayList<StackHolder>
    {
        return try {
            val gson=Gson()
            val listType = object : TypeToken<ArrayList<StackHolder>>() { }.type
            gson.fromJson(context?.getSharedPreferences(favdata,Context.MODE_PRIVATE)?.getString(favdata, null), listType)
        }catch (e:NullPointerException) {
            ArrayList()
        }catch (e:JsonParseException) {
            ArrayList()
        }catch (e:IllegalStateException)
        {
            ArrayList()
        }
    }



    var name: String?
        get() = pref.getString(NAME, null)
        set(value) = pref.edit().putString(NAME, value).apply()
    var city: String?
        get() = pref.getString(City, null)
        set(value) = pref.edit().putString(City, value).apply()
    var image: String?
        get() = pref.getString(ImageUrl, null)
        set(value) = pref.edit().putString(ImageUrl, value).apply()
}