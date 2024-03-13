package com.guesthouse.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guesthouse.designsystem.R
import com.guesthouse.designsystem.theme.Gray70
import com.guesthouse.designsystem.theme.GuestHouseTheme
import com.guesthouse.designsystem.theme.Primary
import com.guesthouse.designsystem.theme.pretendard

@Composable
fun GHTextField() {

}

@Composable
fun GHEOutLinedEmailField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    hint: String = "",
) {

    OutlinedTextField(
        modifier = modifier
            .height(46.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Gray70,
            focusedBorderColor = Primary,
        ),
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        textStyle = TextStyle(
            fontFamily = pretendard,
            fontSize = 12.sp,
        ),
        placeholder = { if(value.isEmpty()) {Text(text = hint, fontFamily = pretendard, fontSize = 12.sp, color = Gray70, lineHeight = 12.sp) }},
        singleLine = true,
        leadingIcon = {
            Image(
                painter = painterResource(
                    id =
                    if (value.isNotEmpty()) {
                        R.drawable.icon_email_entered
                    } else {
                        R.drawable.icon_email_default
                    }
                ),
                contentDescription = ""
            )
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                GHImageButton(
                    containerModifier = Modifier
                        .clip(CircleShape)
                        .size(18.dp)
                        .background(Gray70),
                    imageModifier = Modifier.size(6.75.dp),
                    imageColorFilter = ColorFilter.tint(Color.White),
                    onClick = { onValueChange("") },
                    imageResId = R.drawable.icon_cancel,
                    imageDescriptionResId = R.string.email_text_input_area
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
    )
}

@Preview(apiLevel = 33)
@Composable
fun GHEOutLinedEmailFieldPreview() {
    GuestHouseTheme {
        GHEOutLinedEmailField(
            value = "",
            onValueChange = {},
            hint = "zzxdlkfjas"
        )
    }
}

