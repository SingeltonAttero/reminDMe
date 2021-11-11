package ru.weber.remindme.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = DarkColor.primary,
    primaryVariant = DarkColor.primaryVariant,
    secondary = DarkColor.secondary,
    secondaryVariant = DarkColor.secondaryVariant,
    background = DarkColor.background,
    surface = DarkColor.surface,
    error = DarkColor.error,
    onPrimary = DarkColor.onPrimary,
    onSecondary = DarkColor.onSecondary,
    onBackground = DarkColor.onBackground,
    onSurface = DarkColor.onSurface,
    onError = DarkColor.onError
)

private val LightColorPalette = lightColors(
    primary = LightColor.primary,
    primaryVariant = LightColor.primaryVariant,
    secondary = LightColor.secondary,
    secondaryVariant = LightColor.secondaryVariant,
    background = LightColor.background,
    surface = LightColor.surface,
    error = LightColor.error,
    onPrimary = LightColor.onPrimary,
    onSecondary = LightColor.onSecondary,
    onBackground = LightColor.onBackground,
    onSurface = LightColor.onSurface,
    onError = LightColor.onError
)

@Composable
fun RemindMeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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