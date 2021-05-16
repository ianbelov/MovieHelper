package com.a.moviehelper.core.network.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object ParserModule {

    @Singleton
    @Provides
    fun provideKotlinJsonAdapterFactory(): KotlinJsonAdapterFactory = KotlinJsonAdapterFactory()

    @Singleton
    @Provides
    fun provideMoshi(kotlinJsonAdapterFactory: KotlinJsonAdapterFactory): Moshi = Moshi.Builder()
        .add(kotlinJsonAdapterFactory)
        .build()

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)
}