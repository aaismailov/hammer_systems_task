package com.example.hammer_systems_task.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hammer_systems_task.R

val Roboto = FontFamily(
    Font(R.font.roboto_regular),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_medium, FontWeight.Medium),
)

val SFUIDisplay = FontFamily(
    Font(R.font.sfuidisplay_regular),
    Font(R.font.sfuidisplay_semibold, FontWeight.SemiBold)
)

val Inter = FontFamily(
    Font(R.font.inter_medium, FontWeight.Medium)
)

val Typography = Typography(
    h5 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = SFUIDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = SFUIDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = SFUIDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        letterSpacing = 0.25.sp
    ),
    caption = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.25.sp
    )
)