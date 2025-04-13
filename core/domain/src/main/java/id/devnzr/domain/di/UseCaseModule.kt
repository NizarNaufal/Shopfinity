package id.devnzr.domain.di

import id.devnzr.domain.interfaces.AddCartsUseCase
import id.devnzr.domain.interfaces.GetAllCartsUseCase
import id.devnzr.domain.interfaces.GetProductListUseCase
import id.devnzr.domain.interfaces.GetTokenUseCase
import id.devnzr.domain.interfaces.GetUserUseCase
import id.devnzr.domain.interfaces.LoginUseCase
import id.devnzr.domain.usecase.AddCartsUseCaseImpl
import id.devnzr.domain.usecase.GetAllCartsUseCaseImpl
import id.devnzr.domain.usecase.GetProductListUseCaseImpl
import id.devnzr.domain.usecase.GetTokenUseCaseImpl
import id.devnzr.domain.usecase.GetUserUseCaseImpl
import id.devnzr.domain.usecase.LoginUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetProductListUseCase> {
        GetProductListUseCaseImpl(get())
    }
    single<GetAllCartsUseCase> {
        GetAllCartsUseCaseImpl(get())
    }
    single<GetUserUseCase> {
        GetUserUseCaseImpl(get())
    }
    single<LoginUseCase> {
        LoginUseCaseImpl(get())
    }
    single<GetTokenUseCase> {
        GetTokenUseCaseImpl(get())
    }
    single<AddCartsUseCase> {
        AddCartsUseCaseImpl(get())
    }
}
