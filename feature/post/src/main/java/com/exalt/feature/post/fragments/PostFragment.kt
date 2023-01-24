package com.exalt.feature.post.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.exalt.core.ui.extensions.handleVisibility
import com.exalt.core.ui.extensions.loadImage
import com.exalt.core.ui.extensions.loadUserImage
import com.exalt.feature.post.adapters.CommentListAdapter
import com.exalt.feature.post.adapters.TagListAdapter
import com.exalt.feature.post.databinding.FragmentPostBinding
import com.exalt.feature.post.viewmodels.PostViewModel
import com.exalt.feature.post.viewobjects.PostVO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostFragment : Fragment() {

    private var _binding: FragmentPostBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.postId = arguments?.getString("postId").orEmpty() //"60d21b8667d0d8992e610d3f"

        setUpToolbar()
        setUpCommentList()

        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpToolbar() {
        val drawable = ContextCompat.getDrawable(requireContext(), com.google.android.material.R.drawable.abc_ic_ab_back_material)
        binding.postToolbar.navigationIcon = drawable
        binding.postToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setUpCommentList() {
        binding.commentList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CommentListAdapter().apply {
                onUserClick = { userId ->
                    navigateToUserFragment(userId)
                }
            }
        }
    }

    private fun initObservers() {

        viewModel.isLoading.observe(viewLifecycleOwner) { isVisible ->
            binding.progressPost.handleVisibility(isVisible)
        }

        viewModel.post.observe(viewLifecycleOwner) {
            it?.let { post ->
                initViews(post)
            }
        }

        viewModel.comments.observe(viewLifecycleOwner) { comments ->

            binding.postInformation.postInformationComments.postInfoNumber.text = comments.size.toString()
            (binding.commentList.adapter as CommentListAdapter).submitList(comments)
        }
    }

    private fun initViews(post: PostVO) {

        //Post data
        binding.postText.text = post.text
        binding.postPicture.loadImage(post.imageUri)

        //Post user data
        binding.postUserInfo.postUserName.text = post.ownerName
        binding.postUserInfo.postDate.text = post.publishDate
        binding.postUserInfo.postUserPicture.loadUserImage(post.ownerPictureUri)
        binding.postUserInfo.root.setOnClickListener {
            navigateToUserFragment(post.ownerId)
        }


        //Post Information row
        binding.postInformation.postInformationLikes.postInfoNumber.text = post.likes.toString()
        binding.postInformation.postInformationTags.postInfoNumber.text = post.tags.size.toString()
        binding.postInformation.postInformationComments.postInfoNumber.text = "0"

        //Tag List
        binding.postInformation.tagList.apply {
            adapter = TagListAdapter(post.tags)
        }

    }

    private fun navigateToUserFragment(userId: String) {
        val request = NavDeepLinkRequest.Builder
            .fromUri("android-app://com.eXalt.chienstagram/userFragment/$userId".toUri())
            .build()
        findNavController().navigate(request)
    }

}
