package com.example.android_4_lesson_1.ui.fragment.sing.`in`

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.base.BaseFragment
import com.example.android_4_lesson_1.databinding.FragmentSingInBinding
import com.example.android_4_lesson_1.date.local.preferences.PreferenceHelper
import com.example.android_4_lesson_1.date.local.preferences.UserPreferencesData
import com.example.android_4_lesson_1.extension.showText
import com.example.android_4_lesson_1.models.AuthModel
import com.example.android_4_lesson_1.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SingInFragment :
    BaseFragment<FragmentSingInBinding, SingInViewModel>(R.layout.fragment_sing_in) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSingInBinding::bind)
    override val viewModel: SingInViewModel by viewModels()

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    override fun setupSubscribes() = with(binding) {
        binding.btnSing.setOnClickListener {
            val email = loginSingIn.text.toString()
            val password = passwordSingIn.text.toString()
            val authModel = AuthModel("password", email, password)

            viewModel.postUserData(authModel).subscribe(
                onError = {
                    Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_SHORT).show()
                },
                onSuccess = {
                    if (it != null) {
                        userPreferencesData.apply {
                            isAuthorized = true
                            accessToken = it.accessToken
                            refreshToken = it.refreshToken
                        }
                        requireActivity().findNavController(R.id.nav_host_fragment)
                            .navigate(R.id.action_singFlowFragment_to_mainFlowFragment)
                    }
                }
            )
        }
    }
}

//            viewModel.postUserData(authModel).observe(viewLifecycleOwner) {
//                when (it) {
//                    is Resource.Error -> {
//                        showText(it.message.toString())
//                    }
//                    is Resource.Loading -> {
//                    }
//                    is Resource.Success -> {
//                        Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
//                        userPreferencesData.apply {
//                            preferenceHelper.isAuthorize = true
//                        }
//                        requireActivity().findNavController(R.id.nav_host_fragment)
//                            .navigate(R.id.action_singFlowFragment_to_mainFlowFragment)
//                    }
//                }
//            }
//        }
//    }
//}