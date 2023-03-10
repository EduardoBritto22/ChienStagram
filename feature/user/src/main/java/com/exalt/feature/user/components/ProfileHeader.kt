package com.exalt.feature.user.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.core.ui.R
import com.exalt.feature.user.enums.GenderConfig
import com.exalt.feature.user.viewobjects.UserVO
import com.google.accompanist.themeadapter.material3.Mdc3Theme

@Composable
fun ProfileHeader(userVO: UserVO, modifier: Modifier = Modifier) {
    val imageSize = 100.dp
    Box(
        modifier
            .fillMaxWidth()
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(userVO.profileBackground)
                .crossfade(true)
                .build(),
            contentDescription = "profile background picture",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.placeholder),
            modifier = Modifier
                .fillMaxWidth()
                .height(imageSize)
        )


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = imageSize / 2)
                .fillMaxWidth()
        ) {
            UserPicture(
                userVO,
                Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = userVO.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = userVO.dateOfBirth,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}


@Preview
@Composable
private fun ProfileHeaderPreview() {
    Mdc3Theme {
        ProfileHeader(
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
        )

    }
}