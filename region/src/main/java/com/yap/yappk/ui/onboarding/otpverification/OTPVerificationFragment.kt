package com.yap.yappk.ui.onboarding.otpverification

import androidx.fragment.app.viewModels
import com.yap.core.base.BaseFragment
import com.yap.yappk.BR
import com.yap.yappk.R
import com.yap.yappk.databinding.FragmentOtpVerificationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OTPVerificationFragment :
    BaseFragment<FragmentOtpVerificationBinding, IOTPVerification.State, IOTPVerification.ViewModel>(
        R.layout.fragment_otp_verification
    ),
    IOTPVerification.View {
    override fun getBindingVariable(): Int = BR.viewModel
    override val viewModel: OTPVerificationVM by viewModels()

    override fun onClick(id: Int) {

    }

}