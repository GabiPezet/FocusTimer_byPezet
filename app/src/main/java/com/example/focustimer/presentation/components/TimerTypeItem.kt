package com.example.focustimer.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimer.presentation.theme.FocusTimerTheme

@Composable
fun TimerTypeItem(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    onTap: () -> Unit = { }
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(FocusTimerTheme.dimens.paddingSmall)
            .clickable { onTap() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
    }
}

// 1- Anotación de la Preview
@Preview(
    name = "PREVIO DEL TimerTypeItem",
    showBackground = true,
)
// 2- Composable para la Preview
@Composable
fun TimerTypeItem_Preview() {
// 3- Theme (Tema del proyecto)
    FocusTimerTheme {
        TimerTypeItem(text = "On Focus",
            textColor = Color.Black)
    }
}