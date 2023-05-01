

package com.example.kinoroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kinoroom.film.FilmFragment
import com.example.kinoroom.databinding.ActivityMainBinding
import com.example.kinoroom.star.StarFragment
import com.example.kinoroom.zhanr.ZhanrFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fun replaceFragment(fragment: Fragment) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.viewPager, fragment)
            fragmentTransaction.commit()

        }


        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.film -> replaceFragment(FilmFragment())
                R.id.zhanr -> replaceFragment(ZhanrFragment())
                R.id.star -> replaceFragment(StarFragment())

                else -> {}
            }
            true
        }
    }

}

