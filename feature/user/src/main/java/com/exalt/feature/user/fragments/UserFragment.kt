package com.exalt.feature.user.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.exalt.feature.user.screens.UserScreen
import com.exalt.feature.user.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            viewModel.userId = "60d0fe4f5311236168a109ca"
            viewModel.user.observe(viewLifecycleOwner) {
                it?.let { user ->
                    // In Compose world
                    setContent {
                        MaterialTheme {
                            UserScreen(user)
                        }
                    }
                }
            }
        }
    }
}