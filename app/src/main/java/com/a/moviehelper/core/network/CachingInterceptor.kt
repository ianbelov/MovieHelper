package com.a.moviehelper.core.network

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class CachingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response = chain.proceed(chain.request())
        val cacheControl: CacheControl = CacheControl.Builder()
            .maxAge(2, TimeUnit.HOURS)
            .maxStale(2, TimeUnit.HOURS)
            .build()
        return response.newBuilder()
            .removeHeader("Cache-Control")
            .removeHeader("Pragma")
            .header("Cache-Control", cacheControl.toString())
            .build()
    }
}