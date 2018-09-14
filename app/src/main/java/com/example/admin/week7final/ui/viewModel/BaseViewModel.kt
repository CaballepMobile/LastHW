package com.example.admin.week7final.ui.viewModel

import android.arch.lifecycle.ViewModel
import com.example.admin.week7final.di.component.DaggerMainActivityComponent
import com.example.admin.week7final.di.component.MainActivityComponent
import com.example.admin.week7final.di.module.NumberModule

abstract class BaseViewModel: ViewModel() {

    private val mainActivityInjector : MainActivityComponent = DaggerMainActivityComponent
            .builder()
            .networkModule(NumberModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is MainActivityViewModel -> mainActivityInjector.inject(this)
        }
    }
}
