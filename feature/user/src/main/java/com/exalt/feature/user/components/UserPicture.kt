package com.exalt.feature.user.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun UserPicture(
    user: UserVO,
    modifier: Modifier = Modifier
) {
    val imageSize = 100.dp

    Box(modifier = modifier) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(user.pictureUrl)
                .crossfade(true)
                .build(),
            contentDescription = "User picture",
            Modifier
                .size(imageSize)
                .border(BorderStroke(1.dp, user.genderConfig.color), CircleShape)
                .clip(CircleShape),
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(R.drawable.placeholder)
        )

        Icon(
            painterResource(user.genderConfig.icon),
            null,
            modifier = Modifier.align(Alignment.BottomEnd)
                .offset(x = 8.dp)
        )
    }

}

@Preview
@Composable
private fun UserPicturePreview() {
    Mdc3Theme {
        UserPicture(
            UserVO(
                "",
                name = DomainModelFactory.OWNER_FIRST_NAME,
                email = DomainModelFactory.OWNER_EMAIL,
                phone = DomainModelFactory.OWNER_PHONE,
                GenderConfig.OTHER,
                DomainModelFactory.OWNER_BIRTHDATE_RAW,
                pictureUrl = DomainModelFactory.OWNER_PICTURE_URL,
                address = DomainModelFactory.OWNER_ADDRESS,
                profileBackground = "https://as1.ftcdn.net/v2/jpg/04/14/17/88/1000_F_414178875_7GqEVTasELylv9Y7vNxPjDaMCJlAToMR.jpg"
            )
        )
    }
}