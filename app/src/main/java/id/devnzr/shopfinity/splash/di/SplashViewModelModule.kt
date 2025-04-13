package id.devnzr.shopfinity.splash.di

import id.devnzr.shopfinity.splash.screen.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashViewModelModule = module {
    viewModel { SplashViewModel(get()) }
}
