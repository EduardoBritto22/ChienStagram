package com.exalt.feature.user.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exalt.domain.home.models.DomainModelFactory
import com.exalt.feature.user.enums.GenderConfig
import com.exalt.feature.user.viewobjects.UserVO

@Composable
fun ContactInformation(user: UserVO, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(15.dp)) {

        Text(text = "CONTACT INFORMATION", fontSize = 12.sp)
        Divider()
        ContactInformationItem(title = "Email", information = user.email)
        ContactInformationItem(title = "Phone", information = user.phone)
        ContactInformationItem(title = "Address", information = user.address)

    }
}


@Preview
@Composable
private fun ContactInformationPreview() {
    MaterialTheme {
        ContactInformation( UserVO(
            "",
            name = DomainModelFactory.OWNER_FIRST_NAME,
            email = DomainModelFactory.OWNER_EMAIL,
            phone = DomainModelFactory.OWNER_PHONE,
            GenderConfig.MALE,
            DomainModelFactory.OWNER_BIRTHDATE_RAW,
            pictureUrl = DomainModelFactory.OWNER_PICTURE_URL,
            address = DomainModelFactory.OWNER_ADDRESS,
            profileBackground = "https://as1.ftcdn.net/v2/jpg/04/14/17/88/1000_F_414178875_7GqEVTasELylv9Y7vNxPjDaMCJlAToMR.jpg"
        ))
    }
}