package com.example.focustimer.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimer.presentation.theme.FocusTimerTheme

@Composable
fun InformationItem(
    modifier: Modifier = Modifier,
    text: String,
    label: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

// 1- Anotación de la Preview
@Preview(
    name = "PREVIO DEL InformationItem",
    showBackground = true,
)
// 2- Composable para la Preview
@Composable
fun InformationItem_Preview() {
// 3- Theme (Tema del proyecto)
    FocusTimerTheme {
        InformationItem(
            text = "On Focus",
            label = "In Focus")
    }
}