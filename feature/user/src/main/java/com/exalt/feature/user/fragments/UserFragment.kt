package com.exalt.feature.user.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.feature.user.enums.GenderConfig
import com.exalt.feature.user.screens.UserScreen
import com.exalt.feature.user.viewmodels.UserViewModel
import com.exalt.feature.user.viewobjects.UserVO
import com.google.accompanist.themeadapter.material3.Mdc3Theme
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
                    requireContext()

                    // In Compose world
                    setContent {
                        Mdc3Theme {
                            UserScreen(user)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Teste() {
    Mdc3Theme {
        UserScreen( UserVO(
            "",
            name = DomainModelFactory.OWNER_FIRST_NAME,
            email = DomainModelFactory.OWNER_EMAIL,
            phone = DomainModelFactory.OWNER_PHONE,
            GenderConfig.MALE,
            DomainModelFactory.OWNER_BIRTHDATE_RAW,
            pictureUrl = DomainModelFactory.OWNER_PICTURE_URL,
            address = DomainModelFactory.OWNER_ADDRESS,
            profileBackground = "https://as1.ftcdn.net/v2/jpg/04/14/17/88/1000_F_414178875_7GqEVTasELylv9Y7vNxPjDaMCJlAToMR.jpg"
        )
        )
    }
}