package com.exalt.feature.user.enums

import androidx.compose.ui.graphics.Color
import com.exalt.feature.user.R

enum class GenderConfig(val icon: Int, val color: Color) {
    OTHER(R.drawable.ic_other,Color.Gray),
    MALE(R.drawable.ic_male,Color.Blue),
    FEMALE(R.drawable.ic_female,Color.Magenta)
}