package ru.weber.remindme.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PrimaryDark,
    primaryVariant = PrimaryVariantDark,
    surface = SurfaceDark,
    secondary = PrimaryAccentDark,
    background = PrimaryVariantDark,
    error = PrimaryTextErrorDark
)

private val LightColorPalette = lightColors(
    primary = PrimaryLight,
    primaryVariant = PrimaryVariantLight,
    surface = SurfaceLight,
    secondary = PrimaryAccentLight,
    background = PrimaryVariantLight,
    error = PrimaryTextErrorLight
)

@Composable
fun RemindMeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val typography = if (darkTheme) TypographyDark else TypographyLight

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}