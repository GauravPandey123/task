package com.swipewcards.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

import java.text.SimpleDateFormat
import java.util.*

fun View.showSnackbar(message: String, snackbarLength: Int) {
    val snackbar = Snackbar.make(
        this, message,
        snackbarLength
    )
    snackbar.setActionTextColor(Color.BLUE)
    val snackbarView = snackbar.view
    snackbar.setTextColor(Color.WHITE)
    snackbarView.setBackgroundColor(Color.BLACK)
    snackbar.show()
}

fun Context.isOnline(): Boolean {

    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    //should check null because in airplane mode it will be null
    return netInfo != null && netInfo.isConnected
}





fun hideKeyboardFrom(context: Context, view: View) {
    val imm: InputMethodManager =
        context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}









fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    formatter.timeZone = timeZone
    return formatter.format(this)
}

fun Long.showTime(): String {
    val calender = Calendar.getInstance()
    val calendarNow = Calendar.getInstance()
    calendarNow.time = Date()
    calender.time = Date(this)
    val year = calender.get(Calendar.YEAR)
    val month = calender.get(Calendar.MONTH)
    val day = calender.get(Calendar.DAY_OF_MONTH)
    val yearNow = calendarNow.get(Calendar.YEAR)
    val monthNow = calendarNow.get(Calendar.MONTH)
    val dayNow = calendarNow.get(Calendar.DAY_OF_MONTH)
    val yearDiff = yearNow - year
    val monthDiff = monthNow - month
    val dayDiff = dayNow - day

    return if (yearDiff != 0) {
        SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date(this))
    } else {
        if (monthDiff != 0) {
            SimpleDateFormat("dd MMM", Locale.getDefault()).format(Date(this))
        } else {
            when (dayDiff) {
                0 -> SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date(this))
                1 -> "Yesterday"
                else -> SimpleDateFormat("dd MMM", Locale.getDefault()).format(Date(this))
            }
        }
    }
}
