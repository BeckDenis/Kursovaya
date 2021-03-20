package com.example.kursovaya.networking

import com.example.kursovaya.models.Movie
import com.example.kursovaya.models.Movies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Добавляем api запрос возвращающий популярные фильмы


interface PopularMoviesApi {
    @GET("tv/popular")
    suspend fun getPopularMovies(): Movies
}

interface MovieApi {
    @GET("tv/{id}")
    suspend fun getMovie(@Path("id") id: Int): Movie
}