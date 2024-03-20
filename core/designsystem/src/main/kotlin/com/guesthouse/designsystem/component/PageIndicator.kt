package com.guesthouse.designsystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.guesthouse.designsystem.theme.Neutral50
import com.guesthouse.designsystem.theme.Primary


@Composable
fun GHPageIndicator(
    numberOfPages: Int,
    modifier: Modifier = Modifier,
    selectedPage: Int = 0,
    selectedColor: Color = Primary,
    defaultColor: Color = Neutral50,
    selectedRadius: Dp = 6.dp,
    selectedWidth: Dp = 24.dp,
    selectedHeight: Dp = 10.dp,
    defaultRadius: Dp = 6.dp,
    defaultWidth: Dp = 8.dp,
    defaultHeight: Dp = 8.dp,
    space: Dp = 8.dp,
    animationDurationInMillis: Int = 300,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space),
        modifier = modifier,
    ) {
        for (i in 0 until numberOfPages) {
            val isSelected = i == selectedPage
            GHPageIndicatorView(
                isSelected = isSelected,
                selectedColor = selectedColor,
                defaultColor = defaultColor,
                defaultRadius = defaultRadius,
                selectedRadius = selectedRadius,
                selectedWidth = selectedWidth,
                selectedHeight = selectedHeight,
                defaultWidth = defaultWidth,
                defaultHeight = defaultHeight,
                animationDurationInMillis = animationDurationInMillis,
            )
        }
    }
}

@Composable
private fun GHPageIndicatorView(
    isSelected: Boolean,
    selectedColor: Color,
    defaultColor: Color,
    defaultRadius: Dp,
    animationDurationInMillis: Int,
    modifier: Modifier = Modifier,
    selectedRadius: Dp,
    selectedWidth: Dp,
    selectedHeight: Dp,
    defaultWidth: Dp,
    defaultHeight: Dp,
) {

    val color: Color by animateColorAsState(
        targetValue = if (isSelected) {
            selectedColor
        } else {
            defaultColor
        },
        animationSpec = tween(
            durationMillis = animationDurationInMillis,
        ), label = ""
    )
    val width: Dp by animateDpAsState(
        targetValue = if (isSelected) {
            selectedWidth
        } else {
            defaultWidth
        },
        animationSpec = tween(
            durationMillis = animationDurationInMillis,
        ), label = ""
    )
    val height: Dp by animateDpAsState(
        targetValue = if (isSelected) {
            selectedHeight
        } else {
            defaultHeight
        },
        animationSpec = tween(
            durationMillis = animationDurationInMillis,
        ), label = ""
    )
    val radius: Dp by animateDpAsState(
        targetValue = if (isSelected) {
            selectedRadius
        } else {
            defaultRadius
        },
        animationSpec = tween(
            durationMillis = animationDurationInMillis,
        ), label = ""
    )

    Canvas(
        modifier = modifier
            .size(
                width = width,
                height = height,
            ),
    ) {
        drawRoundRect(
            color = color,
            topLeft = Offset.Zero,
            size = Size(
                width = width.toPx(),
                height = height.toPx(),
            ),
            cornerRadius = CornerRadius(
                x = radius.toPx(),
                y = radius.toPx(),
            ),
        )
    }
}