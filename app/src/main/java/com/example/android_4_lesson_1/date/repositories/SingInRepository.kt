package com.example.android_4_lesson_1.date.repositories

import com.example.android_4_lesson_1.base.BaseRepository
import com.example.android_4_lesson_1.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SingInRepository @Inject constructor() : BaseRepository() {

    fun singIn(password: String, login: String) = flow {
        emit(Resource.Loading())
        when {
            login != "Jafar" -> {
                emit(Resource.Error("Не верный логин!!!"))
            }
            password != "123456" -> {
                emit(Resource.Error("Не верный пароль!!!"))
            }
            else -> {
                emit(Resource.Success("Все верно!!!"))
            }
        }
    }
}