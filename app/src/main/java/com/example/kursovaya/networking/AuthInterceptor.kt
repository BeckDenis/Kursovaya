package com.example.kursovaya.networking

import com.example.kursovaya.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

// Добавляем API_KEY в наши сетевые запросы

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url().newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}