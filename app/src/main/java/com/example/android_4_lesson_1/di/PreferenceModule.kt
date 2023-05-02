package com.example.android_4_lesson_1.di

import android.content.Context
import com.example.android_4_lesson_1.date.local.preferences.PreferenceHelper
import com.example.android_4_lesson_1.date.local.preferences.UserPreferencesData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context) = PreferenceHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferenceData(preferenceHelper: PreferenceHelper) =
        UserPreferencesData(preferenceHelper)
}