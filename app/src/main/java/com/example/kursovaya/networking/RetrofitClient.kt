package com.example.kursovaya.networking

import com.example.kursovaya.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Создаём retrofit client для обработки сетевых запросов
fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

// создаём okHttp клиент для сетевых запросов
fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

// Делает api запрос возвращающий список популярных фильмов
fun providePopularMoviesApi(retrofit: Retrofit): MoviesApi.PopularMoviesApi = retrofit.create(MoviesApi.PopularMoviesApi::class.java)
