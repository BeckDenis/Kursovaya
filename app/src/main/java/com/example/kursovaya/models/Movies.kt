package com.example.kursovaya.models

// Список фильмов
data class Movies(val results: List<Movie>)

// Отдельный фильм
data class Movie(
    val id: Int,
    val poster_path: String,
    val title: String
)