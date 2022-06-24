package com.digitify.testyappakistan.onboarding.demo

import androidx.activity.viewModels
import com.digitify.testyappakistan.BR
import com.digitify.testyappakistan.R
import com.digitify.testyappakistan.databinding.DemoActivityMainBinding
import com.yap.core.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DemoMainActivity : BaseActivity<DemoActivityMainBinding, IMain.State, IMain.ViewModel>(),
    IMain.View {
    override fun getLayoutId(): Int = R.layout.demo_activity_main
    override fun getBindingVariable(): Int = BR.viewModel
    override val viewModel: IMain.ViewModel by viewModels<MainViewModel>()


}