package com.exalt.feature.user.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exalt.domain.home.models.DomainModelFactory.OWNER_ADDRESS
import com.exalt.domain.home.models.DomainModelFactory.OWNER_BIRTHDATE_RAW
import com.exalt.domain.home.models.DomainModelFactory.OWNER_EMAIL
import com.exalt.domain.home.models.DomainModelFactory.OWNER_FIRST_NAME
import com.exalt.domain.home.models.DomainModelFactory.OWNER_PHONE
import com.exalt.domain.home.models.DomainModelFactory.OWNER_PICTURE_URL
import com.exalt.feature.user.components.UserPicture
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
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) {
        Surface {
            Column(
                Modifier
                    .heightIn(min = 250.dp, 300.dp)
                    .fillMaxWidth()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val imageSize = 100.dp
                Box(
                    Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondary)
                ) {

                    UserPicture(
                        userVO,
                        Modifier
                            .offset(y = imageSize / 2) // Half of the height
                            .align(Alignment.BottomCenter)
                    )
                }

                Spacer(Modifier.height(imageSize / 2))

                Text(
                    text = userVO.name,
                    fontWeight = FontWeight(600),
                    fontSize = 16.sp
                )

                Text(
                    text = userVO.dateOfBirth,
                    fontSize = 14.sp
                )
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
                    "", name = OWNER_FIRST_NAME, email = OWNER_EMAIL, phone = OWNER_PHONE, GenderConfig.MALE,
                    OWNER_BIRTHDATE_RAW, pictureUrl = OWNER_PICTURE_URL, address = OWNER_ADDRESS
                )
            )
        }
    }

}
