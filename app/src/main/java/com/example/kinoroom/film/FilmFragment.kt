package com.example.kinoroom.film

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kinoroom.PagerAdapter
import com.example.kinoroom.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FilmFragment :Fragment(R.layout.fragment_film) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        setupView(view)
    }

    private fun setupView(view: View) {
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager2)



        viewPager.adapter = PagerAdapter(lifecycle, childFragmentManager)

        TabLayoutMediator(
            tabLayout,
            viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> tab.text = "Soon"
                    1 -> tab.text = "Popular"

                }
            }
        ).attach()
    }

}
