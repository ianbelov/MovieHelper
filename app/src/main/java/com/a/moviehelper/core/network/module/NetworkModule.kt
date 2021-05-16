package com.a.moviehelper.core.network.module

import android.content.Context
import com.a.moviehelper.core.network.CachingInterceptor
import com.a.moviehelper.core.network.NetworkUtils
import com.a.moviehelper.di.module.ContextModule
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import javax.inject.Singleton

@Module(includes = [ParserModule::class, ContextModule::class])
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttp(cache: Cache, cachingInterceptor: CachingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(cachingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofitClient(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
        callAdapterFactory: RxJava3CallAdapterFactory
    ): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(NetworkUtils.BASE_URL)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(moshiConverterFactory)
        .build()

    @Provides
    fun provideCallAdapter(): RxJava3CallAdapterFactory = RxJava3CallAdapterFactory.create()

    @Provides
    fun provideCache(cacheFile: File): Cache {
        return Cache(cacheFile, 5 * 1024 * 1024)
    }

    @Provides
    fun provideFile(context: Context): File {
        val file: File = File(context.cacheDir, "cache_file")
        file.mkdirs()
        return file
    }

    @Provides
    fun provideCachingInterceptor(): CachingInterceptor {
        return CachingInterceptor()
    }
}