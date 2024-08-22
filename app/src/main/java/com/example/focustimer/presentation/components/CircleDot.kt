package com.example.focustimer.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimer.presentation.theme.FocusTimerTheme

@Composable
fun CircleDot(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Box(
        modifier = modifier
            .size(FocusTimerTheme.dimens.iconSizeNormal)
            .clip(shape = CircleShape)
            .background(color)
    )
}


// 1- Anotación de la Preview
@Preview(
    name = "PREVIO DEL CircleDot",
    showBackground = true,
)
// 2- Composable para la Preview
@Composable
fun CircleDot_Preview() {
// 3- Theme (Tema del proyecto)
    FocusTimerTheme {
        CircleDot(
            color = Color.Green
        )
    }
}