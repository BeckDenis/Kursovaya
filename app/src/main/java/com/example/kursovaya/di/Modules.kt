package com.example.kursovaya.di

import com.example.kursovaya.networking.AuthInterceptor
import com.example.kursovaya.networking.provideOkHttpClient
import com.example.kursovaya.networking.providePopularMoviesApi
import com.example.kursovaya.networking.provideRetrofit
import com.example.kursovaya.screens.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { providePopularMoviesApi(get()) }
    single { provideRetrofit(get()) }
}

val viewModelModule = module {
    viewModel { MoviesViewModel(get()) }
}