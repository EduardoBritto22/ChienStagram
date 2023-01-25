package com.exalt.feature.post.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.exalt.core.ui.extensions.handleVisibility
import com.exalt.core.ui.extensions.loadImage
import com.exalt.core.ui.extensions.loadUserImage
import com.exalt.feature.post.adapters.CommentListAdapter
import com.exalt.feature.post.adapters.TagListAdapter
import com.exalt.feature.post.databinding.FragmentPostBinding
import com.exalt.feature.post.viewmodels.PostViewModel
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

        viewModel.postId = "60d21b8667d0d8992e610d3f"

        setUpToolbar()
        binding.commentList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CommentListAdapter()
        }
        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpToolbar() {
        binding.postToolbar.setNavigationIcon(com.exalt.core.ui.R.drawable.ic_back)
        binding.postToolbar.setNavigationOnClickListener {

        }
    }

    private fun initObservers() {

        viewModel.isLoading.observe(viewLifecycleOwner) { isVisible ->
            binding.progressPost.handleVisibility(isVisible)
        }

        viewModel.post.observe(viewLifecycleOwner) {
            it?.let { post ->

                binding.postText.text = post.text
                binding.postPicture.loadImage(post.imageUri)

                binding.postUserInfo.postUserName.text = post.ownerName
                binding.postUserInfo.postDate.text = post.publishDate

                binding.postUserInfo.postUserPicture.loadUserImage(post.ownerPictureUri)

                binding.postInformation.postInformationLikes.postInfoNumber.text = post.likes.toString()
                binding.postInformation.postInformationTags.postInfoNumber.text = post.tags.size.toString()
                binding.postInformation.postInformationComments.postInfoNumber.text = "0"

                binding.postInformation.tagList.apply {
                    adapter = TagListAdapter(post.tags)
                }
            }
        }

        viewModel.comments.observe(viewLifecycleOwner) { comments ->

            binding.postInformation.postInformationComments.postInfoNumber.text = comments.size.toString()
            (binding.commentList.adapter as CommentListAdapter).submitList(comments)
        }
    }

}
