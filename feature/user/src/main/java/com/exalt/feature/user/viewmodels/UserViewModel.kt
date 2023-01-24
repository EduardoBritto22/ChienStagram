package com.exalt.feature.user.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exalt.core.domain.home.usecases.GetOwnerUseCase
import com.exalt.feature.user.mappers.UserVoMapper
import com.exalt.feature.user.states.UserUiState
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

    var userId = savedState.get<String>("userId").orEmpty()

    private val _uiState: MutableStateFlow<UserUiState> = MutableStateFlow(
        UserUiState()
    )

    val uiState get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                user =  userVoMapper.toUserVO(getOwnerUseCase.invoke(userId))
            )
        }
    }
}