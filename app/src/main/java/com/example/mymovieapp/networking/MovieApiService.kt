package com.example.mymovieapp.networking

import com.example.mymovieapp.model.data.PopularMoviesResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ):Response<PopularMoviesResponse>
}