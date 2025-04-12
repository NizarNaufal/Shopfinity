package id.devnzr.domain.di

import id.devnzr.domain.interfaces.GetAllCartsUseCaseContract
import id.devnzr.domain.interfaces.GetProductListUseCaseContract
import id.devnzr.domain.usecase.GetAllCartsUseCase
import id.devnzr.domain.usecase.GetProductListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<GetProductListUseCaseContract> {
        GetProductListUseCase(get())
    }
    single<GetAllCartsUseCaseContract> {
        GetAllCartsUseCase(get())
    }
}