package com.example.android_4_lesson_1.ui.fragment.sing.`in`

import com.example.android_4_lesson_1.base.BaseViewModel
import com.example.android_4_lesson_1.date.repositories.PostUserDataRepository
import com.example.android_4_lesson_1.models.AuthModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor(
    private val postUserDataRepository: PostUserDataRepository
): BaseViewModel() {

    fun postUserData(authModel: AuthModel) = postUserDataRepository.postUserData(authModel)
}
