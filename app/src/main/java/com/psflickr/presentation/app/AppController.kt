package com.psflickr.presentation.app

import android.app.Application
import com.psflickr.di.app.AppComponent
import com.psflickr.di.app.AppModule
import com.psflickr.di.app.DaggerAppComponent

class AppController : Application() {
    companion object {
        lateinit var instance: AppController
            private set
    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        initComponent()
    }

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }
}