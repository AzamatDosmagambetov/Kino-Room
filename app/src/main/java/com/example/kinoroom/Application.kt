package com.example.kinoroom

import android.app.Application

import com.example.kinoroom.di.viewModelModule
import com.example.kinoroom.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }


    private fun initKoin() {
        startKoin{
            androidContext(applicationContext)
            modules(arrayListOf(
                networkModule,
                viewModelModule
            ))
        }
    }

}