package com.exalt.feature.user.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.exalt.domain.home.usecases.GetOwnerUseCase
import com.exalt.feature.user.mappers.UserVoMapper
import com.exalt.feature.user.viewobjects.UserVO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getOwnerUseCase: GetOwnerUseCase,
    private val userVoMapper: UserVoMapper,
) : ViewModel() {

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    var userId = ""

    val user: LiveData<UserVO?> = liveData {
        emit(
            userVoMapper.toUserVO(getOwnerUseCase.invoke(userId))
        )
        _isLoading.value = false
    }

}