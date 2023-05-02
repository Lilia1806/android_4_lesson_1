package com.example.android_4_lesson_1.ui.fragment.sing

import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.base.BaseFlowFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingFlowFragment : BaseFlowFragment(R.layout.fragment_sing_flow) {
    override val navigationId: Int
        get() = R.id.sing_nav_host_fragment
}