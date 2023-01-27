package com.exalt.feature.user.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .height(imageSize)
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
            modifier = Modifier.fillMaxWidth()
        )

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