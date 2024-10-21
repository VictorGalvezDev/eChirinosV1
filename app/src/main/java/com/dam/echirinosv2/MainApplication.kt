package com.dam.echirinosv2

import android.app.Application
import com.dam.echirinosv2.data.AppContainer
import com.dam.echirinosv2.data.DefaultAppContainer

class MainApplication : Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}