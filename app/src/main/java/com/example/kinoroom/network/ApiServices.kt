package com.example.kinoroom.network


import com.example.kinoroom.film.model.Films
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

    @GET("movie/3?api_key=02da584cad2ae31b564d940582770598&language=en-US")
    fun getAnimeList(): Call<FilmDTO>
}