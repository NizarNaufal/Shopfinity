package id.devnzr.shopfinity.detail.di

import id.devnzr.shopfinity.detail.screen.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailViewModelModule = module {
    viewModel { DetailViewModel(get(), get(), get()) }
}
