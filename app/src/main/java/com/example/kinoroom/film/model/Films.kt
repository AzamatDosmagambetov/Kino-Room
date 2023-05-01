package com.example.kinoroom.film.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Films(
    val overview: String,
    val popularity: String,
    val backdrop_path: String

): Parcelable