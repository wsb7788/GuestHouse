package com.guesthouse.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guesthouse.designsystem.theme.Neutral100
import com.guesthouse.designsystem.theme.NeutralWhite
import com.guesthouse.designsystem.theme.Primary
import com.guesthouse.designsystem.theme.pretendard

@Composable
fun GHButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary,
            contentColor = NeutralWhite,
            disabledContainerColor = Neutral100,
            disabledContentColor = NeutralWhite,
        ),
        contentPadding = contentPadding,
        content = content,
    )
}

@Composable
fun GHButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    text: String,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    GHButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
    ) {
        GHButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}

@Composable
private fun GHButtonContent(
    text: String,
    leadingIcon: @Composable (() -> Unit)?
) {
    if (leadingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
            leadingIcon()
        }
    }
    Box(
        Modifier
            .padding(
                start = if (leadingIcon != null) {
                    ButtonDefaults.IconSpacing
                } else {
                    0.dp
                },
            ),
    ) {
        Text(
            text = text,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }

}

@Composable
fun GHImageButton(
    containerModifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    imageColorFilter: ColorFilter? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    imageResId: Int,
    imageDescriptionResId: Int,
) {
    IconButton(
        modifier = containerModifier,
        onClick = {
            onClick()
        },
        enabled = enabled
    ) {
        Image(
            modifier = imageModifier,
            colorFilter = imageColorFilter,
            painter = painterResource(id = imageResId),
            contentDescription = stringResource(imageDescriptionResId)
        )
    }
}

@Preview(group = "GHButton", apiLevel = 33)
@Composable
private fun GHButtonPreview() {
    GHButton(onClick = { }, text = "로그인")
}

@Preview(group = "GHButton", apiLevel = 33)
@Composable
private fun GHButtonDisabledPreview() {
    GHButton(onClick = { }, text = "로그인", enabled = false)
}
