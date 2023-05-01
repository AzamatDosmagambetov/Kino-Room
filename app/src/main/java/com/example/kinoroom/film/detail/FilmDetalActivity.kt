package com.example.kinoroom.film.detail
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.kinoroom.film.model.Films
import com.example.kinoroom.R


class FilmDetalActivity: AppCompatActivity(){
    var films: Films? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_popular_detal)

        films = intent.getParcelableExtra<Films>("ARG_CHAT") as Films
        setupView()


    }



    private fun setupView() {
        val textView = findViewById<TextView>(R.id.filmAverageView)
        val textView2 = findViewById<TextView>(R.id.opisanieFilmView)
        val filmPoster = findViewById<AppCompatImageView>(R.id.avatarView)


        val greeting = if(films?.popularity.equals("Kaira")) "Hitler" else films?.popularity
        textView.text = "Hi $greeting"

        val greeting2 = if(films?.overview.equals("Kaira")) "Hitler" else films?.overview
        textView2.text = "Hi $greeting2"

        Glide
            .with(this)
            .load(films?.backdrop_path)
            .centerCrop()
            .placeholder(R.drawable.ic_icon_star)
            .into(filmPoster)



    }


}