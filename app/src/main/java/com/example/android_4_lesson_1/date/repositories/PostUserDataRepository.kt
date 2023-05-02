package com.example.android_4_lesson_1.date.repositories

import com.example.android_4_lesson_1.base.BaseRepository
import com.example.android_4_lesson_1.date.remote.apiservce.SignInApiService
import com.example.android_4_lesson_1.models.AuthModel
import javax.inject.Inject

class PostUserDataRepository @Inject constructor(
    private val api: SignInApiService
): BaseRepository() {
    fun postUserData(authModel: AuthModel) = doRequest {
        api.postAuthDataUser(authModel)
    }
}