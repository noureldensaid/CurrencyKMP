package org.coinz.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val light_primary = Color(0xFF006B58)
val light_onPrimary = Color(0xFFFFFFFF)
val light_primaryContainer = Color(0xFF7BF8D8)
val light_onPrimaryContainer = Color(0xFF002019)
val light_secondary = Color(0xFF4B635B)
val light_onSecondary = Color(0xFFFFFFFF)
val light_secondaryContainer = Color(0xFFCDE9DE)
val light_onSecondaryContainer = Color(0xFF07201A)
val light_tertiary = Color(0xFF426277)
val light_onTertiary = Color(0xFFFFFFFF)
val light_tertiaryContainer = Color(0xFFC6E7FF)
val light_onTertiaryContainer = Color(0xFF001E2D)
val light_error = Color(0xFFBA1A1A)
val light_errorContainer = Color(0xFFFFDAD6)
val light_onError = Color(0xFFFFFFFF)
val light_onErrorContainer = Color(0xFF410002)
val light_background = Color(0xFFFBFDFA)
val light_onBackground = Color(0xFF191C1B)
val light_surface = Color(0xFFFBFDFA)
val light_onSurface = Color(0xFF191C1B)
val light_surfaceVariant = Color(0xFFDBE5E0)
val light_onSurfaceVariant = Color(0xFF3F4945)
val light_outline = Color(0xFF6F7975)
val light_inverseOnSurface = Color(0xFFEFF1EE)
val light_inverseSurface = Color(0xFF2E3130)
val light_inversePrimary = Color(0xFF5DDBBC)
val light_shadow = Color(0xFF000000)
val light_surfaceTint = Color(0xFF006B58)
val light_outlineVariant = Color(0xFFBFC9C4)
val light_scrim = Color(0xFF000000)

val dark_primary = Color(0xFF5DDBBC)
val dark_onPrimary = Color(0xFF00382D)
val dark_primaryContainer = Color(0xFF005142)
val dark_onPrimaryContainer = Color(0xFF7BF8D8)
val dark_secondary = Color(0xFFB2CCC3)
val dark_onSecondary = Color(0xFF1D352E)
val dark_secondaryContainer = Color(0xFF334C44)
val dark_onSecondaryContainer = Color(0xFFCDE9DE)
val dark_tertiary = Color(0xFFA9CBE3)
val dark_onTertiary = Color(0xFF0F3447)
val dark_tertiaryContainer = Color(0xFF294A5E)
val dark_onTertiaryContainer = Color(0xFFC6E7FF)
val dark_error = Color(0xFFFFB4AB)
val dark_errorContainer = Color(0xFF93000A)
val dark_onError = Color(0xFF690005)
val dark_onErrorContainer = Color(0xFFFFDAD6)
val dark_background = Color(0xFF191C1B)
val dark_onBackground = Color(0xFFE1E3E0)
val dark_surface = Color(0xFF191C1B)
val dark_onSurface = Color(0xFFE1E3E0)
val dark_surfaceVariant = Color(0xFF3F4945)
val dark_onSurfaceVariant = Color(0xFFBFC9C4)
val dark_outline = Color(0xFF89938F)
val dark_inverseOnSurface = Color(0xFF191C1B)
val dark_inverseSurface = Color(0xFFE1E3E0)
val dark_inversePrimary = Color(0xFF006B58)
val dark_shadow = Color(0xFF000000)
val dark_surfaceTint = Color(0xFF5DDBBC)
val dark_outlineVariant = Color(0xFF3F4945)
val dark_scrim = Color(0xFF000000)


val seed = Color(0xFF006B58)


val freshColor = Color(0xFF44FF78)

val staleColor = Color(0xFFFF9E44)

val primaryColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF86A8FC)
    else Color(0xFF283556)

val headerColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF0C0C0C)
    else Color(0xFF283556)

val surfaceColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF161616)
    else Color(0xFFFFFFFF)

val textColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFFFFFF)
    else Color(0xFF000000)