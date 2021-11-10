package ru.weber.remindme.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val TypographyDark = Typography(
    h6 = TextStyle(
        color = SurfaceDark,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.sp
    ),
    body1 = TextStyle(
        color = PrimaryTextDark,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp
    )
)

val TypographyLight = Typography(
    h6 = TextStyle(
        color = SurfaceLight,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.sp,
    ),
    body1 = TextStyle(
        color = PrimaryTextLight,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp
    )
)