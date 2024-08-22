package com.example.focustimer.presentation.components

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimer.presentation.theme.FocusTimerTheme

@Composable
fun BorderedIcon(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    onTap: () -> Unit = {}
) {
    Icon(
        modifier = modifier
            .size(FocusTimerTheme.dimens.iconSizeNormal)
            .border(
                width = FocusTimerTheme.dimens.borderNormal,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
            .padding(FocusTimerTheme.dimens.paddingSmall)
            .clickable { onTap() },
        imageVector = ImageVector.vectorResource(id = icon),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary
    )
}

//
//// 1- Anotación de la Preview
//@Preview(
//    name = "PREVIO DEL BorderedIcon",
//    showBackground = true,
//)
//// 2- Composable para la Preview
//@Composable
//fun BorderedIcon_Preview(){
//// 3- Theme (Tema del proyecto)
//    FocusTimerTheme {
//        BorderedIcon(
//            icon =
//        )
//    }
//}