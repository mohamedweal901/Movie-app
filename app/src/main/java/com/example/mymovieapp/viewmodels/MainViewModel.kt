package com.example.mymovieapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mymovieapp.adapters.MovieInteractionListener
import com.example.mymovieapp.model.data.Movie
import com.example.mymovieapp.model.Repositories.MainRepository
import com.example.mymovieapp.model.State
import kotlinx.coroutines.flow.map

class MainViewModel:ViewModel(), MovieInteractionListener {
    private val repository= MainRepository()
    val popularMovies= repository.getPopulerMovies().map { state ->
        when (state) {
            is State.Success -> {
                val mapped = state.data?.results?.map {
                    Movie(
                        originalTitle = it.originalTitle ?: "",
                        voteAverage = it.voteAverage ?: 0.0,
                        posterLink = "https://image.tmdb.org/t/p/w500${it.posterPath}"
                    )
                }
                State.Success(mapped)
            }
            is State.Error -> State.Error(state.message)
            is State.Loading -> State.Loading
        }
    }.asLiveData()

    override fun onClickMovie(movie: Movie) {
        Log.d("TAG", "Clicked movie: $movie")
    }

}