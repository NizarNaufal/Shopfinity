package id.devnzr.shopfinity.account.di

import id.devnzr.shopfinity.account.screen.AccountViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val accountViewModelModule = module {
    viewModel { AccountViewModel(get()) }
}