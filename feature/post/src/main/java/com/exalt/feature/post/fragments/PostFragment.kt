package com.exalt.feature.post.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.exalt.core.ui.extensions.handleVisibility
import com.exalt.feature.post.adapters.CommentListAdapter
import com.exalt.feature.post.databinding.FragmentPostBinding
import com.exalt.feature.post.viewmodels.PostViewModel

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

        setUpToolbar()
        binding.commentList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CommentListAdapter(this@PostFragment.requireContext())
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

        viewModel.isLoading.observe(viewLifecycleOwner) {isVisible->
            binding.progressPost.handleVisibility(isVisible)
        }

        viewModel.post.observe(viewLifecycleOwner) {
            it?.let {post ->
                binding.postText.text = post.text
            }
        }

        viewModel.comments.observe(viewLifecycleOwner) { comments->
            (binding.commentList.adapter as CommentListAdapter).submitList(comments)
        }
    }

}