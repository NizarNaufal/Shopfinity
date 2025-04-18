package id.devnzr.domain.di

import id.devnzr.domain.interfaces.AddCartsUseCase
import id.devnzr.domain.interfaces.GetAllCartsUseCase
import id.devnzr.domain.interfaces.GetDetailProductUseCase
import id.devnzr.domain.interfaces.GetProductListUseCase
import id.devnzr.domain.interfaces.GetTokenUseCase
import id.devnzr.domain.interfaces.GetUserUseCase
import id.devnzr.domain.interfaces.LoginUseCase
import id.devnzr.domain.interfaces.LogoutUseCase
import id.devnzr.domain.usecase.AddCartsUseCaseImpl
import id.devnzr.domain.usecase.GetAllCartsUseCaseImpl
import id.devnzr.domain.usecase.GetDetailProductUseCaseImpl
import id.devnzr.domain.usecase.GetProductListUseCaseImpl
import id.devnzr.domain.usecase.GetTokenUseCaseImpl
import id.devnzr.domain.usecase.GetUserUseCaseImpl
import id.devnzr.domain.usecase.LoginUseCaseImpl
import id.devnzr.domain.usecase.LogoutUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetProductListUseCase> {
        GetProductListUseCaseImpl(get())
    }
    single<GetDetailProductUseCase> {
        GetDetailProductUseCaseImpl(get())
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
    single<LogoutUseCase> {
        LogoutUseCaseImpl(get())
    }
}
