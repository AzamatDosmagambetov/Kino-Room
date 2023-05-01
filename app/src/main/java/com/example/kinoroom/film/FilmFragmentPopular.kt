package com.example.kinoroom.film

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinoroom.R
import com.example.kinoroom.film.detail.FilmDetalActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmFragmentPopular: Fragment(R.layout.fragment_film_popular)  {
    private val viewModel by viewModel<FilmViewModel>()

    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        observeViewModel()
        viewModel.onViewCreated()
    }

    private fun setupView(view: View){
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeViewModel(){
        viewModel.basketDetailData.observe(viewLifecycleOwner){ animeList ->
            recyclerView.adapter = FilmPopularRecyclerAdapter(
                item = animeList,
                onItemClickListener = { chat ->
                    val intent = Intent(activity, FilmDetalActivity::class.java)
                    intent.putExtra("ARG_CHAT", chat)
                    startActivity(intent)
                }
            )
        }
    }
}