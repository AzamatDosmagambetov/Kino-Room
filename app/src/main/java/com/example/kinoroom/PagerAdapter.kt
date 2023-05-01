package com.example.kinoroom

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kinoroom.film.FilmFragmentPopular
import com.example.kinoroom.film.FilmFragmentSoon

class PagerAdapter(
    lifecycle: Lifecycle,
    fragmentManager: FragmentManager,
): FragmentStateAdapter(fragmentManager, lifecycle) {

    companion object{
        const val PAGE_COUNT = 2
    }

    override fun getItemCount(): Int {
        return PAGE_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FilmFragmentSoon()
            else -> FilmFragmentPopular()
        }
    }
}