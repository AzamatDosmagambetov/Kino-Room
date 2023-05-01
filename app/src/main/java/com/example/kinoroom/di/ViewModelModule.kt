package com.example.kinoroom.di


import com.example.kinoroom.film.FilmViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { FilmViewModel(get()) }
}