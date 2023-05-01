package com.example.kinoroom.di

import com.example.kinoroom.network.createApplicationService
import org.koin.dsl.module

val networkModule = module{
    single { createApplicationService("https://api.themoviedb.org/3/") }

}