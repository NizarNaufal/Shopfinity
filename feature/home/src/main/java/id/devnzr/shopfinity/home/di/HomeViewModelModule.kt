package id.devnzr.shopfinity.home.di

import id.devnzr.shopfinity.home.screen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    viewModel { HomeViewModel(get()) }
}