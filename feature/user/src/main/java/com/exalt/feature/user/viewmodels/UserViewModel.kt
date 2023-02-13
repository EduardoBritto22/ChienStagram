package com.exalt.feature.user.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exalt.core.domain.home.usecases.GetOwnerUseCase
import com.exalt.feature.user.mappers.UserVoMapper
import com.exalt.feature.user.viewobjects.UserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getOwnerUseCase: GetOwnerUseCase,
    private val userVoMapper: UserVoMapper,
    savedState: SavedStateHandle
) : ViewModel() {

    private var userId = savedState.get<String>("userId").orEmpty()

    private val _uiState: MutableStateFlow<UserUiState> = MutableStateFlow(
        UserUiState.Loading
    )

    val uiState get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val userVo = userVoMapper.toUserVO(getOwnerUseCase.invoke(userId))
            if(userVo != null){
                _uiState.value = UserUiState.Success(userVo)
            } else {
                _uiState.value = UserUiState.Error
            }
        }
    }
}