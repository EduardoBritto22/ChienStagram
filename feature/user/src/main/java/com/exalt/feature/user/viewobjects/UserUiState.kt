package com.exalt.feature.user.viewobjects

sealed interface UserUiState {
    data class Success(val userVO: UserVO) : UserUiState
    object Error : UserUiState
    object Loading : UserUiState
}