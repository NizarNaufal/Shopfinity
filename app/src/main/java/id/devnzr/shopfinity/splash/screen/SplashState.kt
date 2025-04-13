package id.devnzr.shopfinity.splash.screen

import id.devnzr.domain.utils.ResultState

data class SplashState(
    val resultState: ResultState<String> = ResultState.Loading()
)
