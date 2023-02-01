package com.exalt.feature.user.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_ADDRESS

@Composable
fun ContactInformationItem(title: String, information: String, modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = title, style = MaterialTheme.typography.titleMedium)
        Text(
            text = information,
            style = MaterialTheme.typography.labelMedium,
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