package com.exalt.feature.user.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.exalt.domain.home.models.DomainModelFactory.OWNER_ADDRESS

@Composable
fun ContactInformationItem(title: String, information: String, modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = title, fontSize = 14.sp)
        Text(
            text = information,
            fontSize = 12.sp,
            fontWeight = FontWeight(600),
            style = LocalTextStyle.current.copy(lineHeight = 15.sp)
        )
    }
}

@Preview
@Composable
private fun ContactInformationItemPreview() {
    MaterialTheme {
        ContactInformationItem(title = "Address", information = OWNER_ADDRESS)
    }

}