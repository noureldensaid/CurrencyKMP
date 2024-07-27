package org.coinz.domain.models

import androidx.compose.ui.graphics.Color
import org.coinz.presentation.theme.freshColor
import org.coinz.presentation.theme.staleColor

enum class RateStatus(
    val statusResId: String,
    val color: Color
) {
    Idle(
        statusResId = "Idle",
        color = Color.White
    ),
    Fresh(
        statusResId = "Fresh",
        color = freshColor
    ),
    Stale(
        statusResId = "Stale",
        color = staleColor
    ),

}