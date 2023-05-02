package com.example.android_4_lesson_1.date.remote.apiservce

import com.example.android_4_lesson_1.models.AuthModel
import com.example.android_4_lesson_1.models.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModel
    ): TokenModel
}