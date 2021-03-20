package com.example.kursovaya.di

import com.example.kursovaya.networking.*
import com.example.kursovaya.screens.MoviesViewModel
import com.example.kursovaya.screens.TvViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { providePopularMoviesApi(get()) }
    factory { provideMovieApi(get()) }
    single { provideRetrofit(get()) }
}

val viewModelModule = module {
    viewModel { MoviesViewModel(get()) }
    viewModel { TvViewModel(get()) }
}