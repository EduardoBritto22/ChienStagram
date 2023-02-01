package com.exalt.feature.user.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.feature.user.R
import com.exalt.feature.user.components.ContactInformation
import com.exalt.feature.user.components.ProfileHeader
import com.exalt.feature.user.enums.GenderConfig
import com.exalt.feature.user.states.UserUiState
import com.exalt.feature.user.viewmodels.UserViewModel
import com.exalt.feature.user.viewobjects.UserVO
import com.google.accompanist.themeadapter.material3.Mdc3Theme

@Composable
fun UserScreen(
    viewModel: UserViewModel,
    onBackClick: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()
    UserScreen(uiState = uiState, onBackClick)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    uiState: UserUiState,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.module_name)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                colors = TopAppBarDefaults
                    .mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
            )
        }
    ) {
        Surface {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                uiState.user?.let { userVO ->

                    ProfileHeader(userVO)

                    ContactInformation(user = userVO, modifier = Modifier.padding(dimensionResource(
                        id = com.exalt.core.ui.R.dimen.groups_padding
                    )))
                }


            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UserScreenPreview() {
    Mdc3Theme {
        Surface {
            UserScreen(
                uiState = UserUiState(
                    UserVO(
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
                ),
                onBackClick = {}
            )
        }
    }
}
