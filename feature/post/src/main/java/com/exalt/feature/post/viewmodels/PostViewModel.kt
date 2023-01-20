package com.exalt.feature.post.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.exalt.domain.home.usecases.GetCommentsByPostUseCase
import com.exalt.domain.home.usecases.GetPostUseCase
import com.exalt.feature.post.mappers.CommentVoMapper
import com.exalt.feature.post.mappers.PostVoMapper
import com.exalt.feature.post.viewobjects.CommentVO
import com.exalt.feature.post.viewobjects.PostVO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    private val getCommentsUseCase: GetCommentsByPostUseCase,
    private val commentVoMapper: CommentVoMapper,
    private val postVoMapper: PostVoMapper,
    ): ViewModel() {

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    var postId = ""
    private var commentsPage = 0u

    val post: LiveData<PostVO> = liveData {
        emit(
            postVoMapper.toPostVO(getPostUseCase.invoke(postId))
        )
        _isLoading.value = false
    }

    val comments: LiveData<List<CommentVO>> = liveData {
        emit(
            commentVoMapper.toListCommentVO(getCommentsUseCase.invoke(postId, commentsPage))
        )
    }

}