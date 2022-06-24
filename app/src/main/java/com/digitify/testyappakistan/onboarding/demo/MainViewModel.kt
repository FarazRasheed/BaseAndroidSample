package com.digitify.testyappakistan.onboarding.demo

import com.yap.core.base.BaseViewModel
import com.yap.core.base.SingleClickEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor()  : BaseViewModel<IMain.State>(), IMain.ViewModel {
    override val viewState: IMain.State = MainState()
    override val clickEvent: SingleClickEvent = SingleClickEvent()
}