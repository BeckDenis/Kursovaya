package com.example.kursovaya.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.bumptech.glide.load.engine.Resource
import com.example.kursovaya.networking.MovieApi

class TvViewModel(private val movieApi: MovieApi) : ViewModel() {

    private val movieId = MutableLiveData(0)

    fun updateMovieId(id: Int) {
        movieId.value = id
    }

    val movie = movieId.switchMap { id ->
        liveData {
            emit(movieApi.getMovie(id))
        }
    }

}