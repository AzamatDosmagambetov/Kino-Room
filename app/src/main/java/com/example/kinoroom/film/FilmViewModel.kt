package com.example.kinoroom.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kinoroom.common.Constants.IMAGE_BASE_URL
import com.example.kinoroom.network.ApiServices
import com.example.kinoroom.film.model.Films
import com.example.kinoroom.network.FilmDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmViewModel(
    private val apiServices: ApiServices
): ViewModel() {

    private val _basketDetailData = MutableLiveData<List<Films>>()
    val basketDetailData: LiveData<List<Films>>
        get() = _basketDetailData

    private val FilmList = mutableListOf<Films>()

    fun onViewCreated(){
        apiServices.getAnimeList().enqueue(object : Callback<FilmDTO> {
            override fun onResponse(call: Call<FilmDTO>, response: Response<FilmDTO>) {
                val responseSuccess = response.body()

                responseSuccess?.let {animeDTO ->

                        FilmList.add(
                            Films(
                                overview = animeDTO.overview,
                                popularity = animeDTO.popularity,
                                backdrop_path = "$IMAGE_BASE_URL${animeDTO.backdrop_path}"

                            )
                        )

                }
                _basketDetailData.value = FilmList
            }

            override fun onFailure(call: Call<FilmDTO>, t: Throwable) {
                //Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }
        })
        getChatSampleData()
    }

    fun getChatSampleData() = mutableListOf<Films>().apply {
        (0..20).forEach {index ->
            if(index%2 == 0) {
                add(
                    Films(
                        overview = "Ansar",
                        popularity = "Hello everyone!!!",
                        backdrop_path = "https://image.tmdb.org/t/p/w500/nj01hspawPof0mJmlgfjuLyJuRN.jpg"
                    )
                )
            } else if(index%3 == 0){
                add(
                    Films(
                        overview = "Kaira",
                        popularity = "Ans Ans!!!",
                        backdrop_path = "https://image.tmdb.org/t/p/w500/nj01hspawPof0mJmlgfjuLyJuRN.jpg"
                        )
                )
            } else{
                add(
                    Films(
                        overview = "Zhasik",
                        popularity = "Ya chert!!!",
                        backdrop_path = "https://image.tmdb.org/t/p/w500/nj01hspawPof0mJmlgfjuLyJuRN.jpg"

                    )
                )
            }
        }
    }

}