package com.example.android_4_lesson_1.ui.fragment.sing.`in`

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_4_lesson_1.base.BaseViewModel
import com.example.android_4_lesson_1.date.repositories.PostUserDataRepository
import com.example.android_4_lesson_1.date.repositories.SingInRepository
import com.example.android_4_lesson_1.models.AuthModel
import com.example.android_4_lesson_1.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor(
    private val postUserDataRepository: PostUserDataRepository
): BaseViewModel() {

    fun postUserData(authModel: AuthModel) = postUserDataRepository.postUserData(authModel)
}
