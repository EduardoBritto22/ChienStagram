package com.exalt.feature.user.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.feature.user.R
import com.exalt.feature.user.enums.GenderConfig
import com.exalt.feature.user.viewobjects.UserVO
import com.google.accompanist.themeadapter.material3.Mdc3Theme

@Composable
fun ContactInformation(user: UserVO, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(id = com.exalt.core.ui.R.dimen.items_space_between)), modifier = modifier) {

        Text(text = stringResource(R.string.contact_information_title), style = MaterialTheme.typography.bodySmall)
        Divider()
        ContactInformationItem(title = stringResource(R.string.contact_info_email), information = user.email)
        ContactInformationItem(title = stringResource(R.string.contact_info_phone), information = user.phone)
        ContactInformationItem(title = stringResource(R.string.contact_info_address), information = user.address)

    }
}


@Preview
@Composable
private fun ContactInformationPreview() {
    Mdc3Theme {
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