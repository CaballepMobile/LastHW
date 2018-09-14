package com.example.admin.week7final.di.component

import com.example.admin.week7final.di.module.NumberModule
import com.example.admin.week7final.ui.viewModel.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NumberModule::class])
interface MainActivityComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)

    @Component.Builder
    interface Builder {
        fun build(): MainActivityComponent
        fun networkModule(networkModule: NumberModule) : Builder
    }
}
