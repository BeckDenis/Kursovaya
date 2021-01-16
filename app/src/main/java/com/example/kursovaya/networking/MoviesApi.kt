package com.example.kursovaya.networking

import retrofit2.http.GET
import retrofit2.http.Query

// Добавляем api запрос возвращающий популярные фильмы

class MoviesApi {
    interface PopularMoviesApi {
        @GET("movie/popular")
        suspend fun getPopularMovies(): Movies
    }
}