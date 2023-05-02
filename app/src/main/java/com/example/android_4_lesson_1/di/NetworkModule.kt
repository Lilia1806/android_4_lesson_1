package com.example.android_4_lesson_1.di

import com.example.android_4_lesson_1.date.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiService() = retrofitClient.provideAnimeApiService()

    @Singleton
    @Provides
    fun provideMangaApiService() = retrofitClient.provideMangaApiService()

    @Singleton
    @Provides
    fun provideSignInApiService() = retrofitClient.providerSignInApiService()
}