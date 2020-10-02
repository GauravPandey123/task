package com.swipewcards

import android.app.Application
import com.swipewcards.sessionmanager.SessionManager


val sessionManager: SessionManager by lazy {
    SwipeCardApplication.sessionManager!!
}
class SwipeCardApplication : Application(){
    companion object {
        var sessionManager: SessionManager? = null

    }
    override fun onCreate() {
        super.onCreate()
        sessionManager = SessionManager(applicationContext)

    }
}