package com.example.kursovaya.screens

import androidx.lifecycle.*
import com.example.kursovaya.networking.PopularMoviesApi

// Создаём viewModel Для архитектуроного подхода MVVM (Model View ViewModel)

// Передаём внутрь Api фильмов
class MoviesViewModel(private val popularMoviesApi: PopularMoviesApi) : ViewModel() {

    // делаем api Запрос. Получаем список фильмов
    val movies = liveData {
        emit(popularMoviesApi.getPopularMovies())
    }

}