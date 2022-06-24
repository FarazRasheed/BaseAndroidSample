package com.yap.yappk.ui.onboarding.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.yap.core.base.BaseNavActivity
import com.yap.yappk.BR
import com.yap.yappk.R
import com.yap.yappk.databinding.YapPkActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapPkMainActivity : BaseNavActivity<YapPkActivityMainBinding, IMain.State, IMain.ViewModel>(),
    IMain.View {
    override fun getLayoutId(): Int = R.layout.yap_pk_activity_main
    override fun getBindingVariable(): Int = BR.viewModel
    override val viewModel: IMain.ViewModel by viewModels<MainViewModel>()
    override val navigationGraphId: Int = R.navigation.onboarding_nav_graph

    override fun onDestinationChanged(
        controller: NavController?,
        destination: NavDestination?,
        arguments: Bundle?
    ) {
        //To use when needed
    }

}