package id.devnzr.shopfinity.login.di

import id.devnzr.shopfinity.login.screen.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginViewModelModule = module {
    viewModel { LoginViewModel(get()) }
}