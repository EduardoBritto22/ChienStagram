package com.exalt.feature.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eXalt.feature.home.R
import com.exalt.feature.home.adapters.PostListAdapter
import com.exalt.core.ui.extensions.handleVisibility
import com.exalt.feature.home.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var postRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postRecyclerView = requireView().findViewById(R.id.posts_list)
        initViews()
        initObservers()
    }

    private fun initViews() {
        postRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PostListAdapter().apply {
                onUserClick = { userId ->
                    // TODO NAVIGATE TO USER SCREEN
                }
                onPostClick = { postId ->
                    // TODO NAVIGATE TO POST SCREEN
                }
            }
        }
    }

    private fun initObservers() {
        homeViewModel.isLoading.observe(viewLifecycleOwner) {
            requireView().findViewById<ProgressBar>(R.id.progress_home).handleVisibility(it)
        }
        homeViewModel.posts.observe(viewLifecycleOwner) {
            (postRecyclerView.adapter as PostListAdapter).submitList(it)
        }
    }
}