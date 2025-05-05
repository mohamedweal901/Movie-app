package com.example.mymovieapp.model.Repositories

import com.example.mymovieapp.model.Constants
import com.example.mymovieapp.model.State
import com.example.mymovieapp.model.data.PopularMoviesResponse
import com.example.mymovieapp.networking.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MainRepository {

    fun getPopulerMovies(): Flow<State<PopularMoviesResponse?>> {
        return wrapWithFlow {
            API.movieApi.getPopularMovies(Constants.API_KEY)
        }
    }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            } catch (exception: Exception) {
                emit(State.Error(exception.message.toString()))
            }
        }
    }
}
