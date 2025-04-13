package id.devnzr.shopfinity.carts.di

import id.devnzr.shopfinity.carts.screen.CartsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cartsViewModelModule = module {
    viewModel { CartsViewModel(get(), get()) }
}
