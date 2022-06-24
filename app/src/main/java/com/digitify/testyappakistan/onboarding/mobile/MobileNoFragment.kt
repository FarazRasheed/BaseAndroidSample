package com.digitify.testyappakistan.onboarding.mobile

import android.content.Intent
import androidx.fragment.app.viewModels
import com.digitify.testyappakistan.BR
import com.digitify.testyappakistan.R
import com.digitify.testyappakistan.databinding.FragmentMobileNoBinding
import com.yap.core.base.BaseFragment
import com.yap.yappk.ui.onboarding.main.YapPkMainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MobileNoFragment :
    BaseFragment<FragmentMobileNoBinding, IMobileNo.State, IMobileNo.ViewModel>(R.layout.fragment_mobile_no),
    IMobileNo.View {
    override fun getBindingVariable(): Int = BR.viewModel
    override val viewModel: MobileNoVM by viewModels()

    override fun onClick(id: Int) {
        when (id) {
            R.id.btnNext -> {
                viewModel.createOtp {
                    val intent = Intent(requireContext(), YapPkMainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }


}