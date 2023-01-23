package com.exalt.feature.user.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_ADDRESS
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_BIRTHDATE_RAW
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_EMAIL
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_FIRST_NAME
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_PHONE
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_PICTURE_URL
import com.exalt.feature.user.components.ContactInformation
import com.exalt.feature.user.components.ProfileHeader
import com.exalt.feature.user.enums.GenderConfig
import com.exalt.feature.user.viewobjects.UserVO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(userVO: UserVO) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Profile") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                colors = TopAppBarDefaults
                    .mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
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

                ProfileHeader(userVO)

                ContactInformation(user = userVO, modifier = Modifier.padding(20.dp))

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UserScreenPreview() {
    MaterialTheme {
        Surface {
            UserScreen(
                UserVO(
                    "",
                    name = OWNER_FIRST_NAME,
                    email = OWNER_EMAIL,
                    phone = OWNER_PHONE,
                    GenderConfig.MALE,
                    OWNER_BIRTHDATE_RAW,
                    pictureUrl = OWNER_PICTURE_URL,
                    address = OWNER_ADDRESS,
                    profileBackground = "https://as1.ftcdn.net/v2/jpg/04/14/17/88/1000_F_414178875_7GqEVTasELylv9Y7vNxPjDaMCJlAToMR.jpg"
                )
            )
        }
    }

}
