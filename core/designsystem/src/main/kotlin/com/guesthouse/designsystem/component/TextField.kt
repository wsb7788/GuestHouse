package com.guesthouse.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun GHEOutLinedEmailField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
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
        placeholder = {
            if(value.isEmpty()) {
                Text(
                    text = "이메일",
                    fontFamily = pretendard,
                    fontSize = 12.sp,
                    color = Gray70,
                    lineHeight = 12.sp
                ) }},
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
                contentDescription = stringResource(R.string.email_text_input_area)
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
                    imageDescriptionResId = R.string.email_text_input_area_clear_button
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
    )
}

@Composable
fun GHOutLinedPasswordField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
) {

    var passwordVisibility by remember { mutableStateOf(false) }

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
        placeholder = {
            if(value.isEmpty()) {
                Text(
                    text = stringResource(R.string.password_hint),
                    fontFamily = pretendard,
                    fontSize = 12.sp,
                    color = Gray70,
                    lineHeight = 12.sp
                ) }},
        singleLine = true,
        leadingIcon = {
            Image(
                painter = painterResource(
                    id =
                    if (value.isNotEmpty()) {
                        R.drawable.icon_password_entered
                    } else {
                        R.drawable.icon_password_default
                    }
                ),
                contentDescription = stringResource(R.string.password_text_input_area)
            )
        },
        visualTransformation = if(passwordVisibility){
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                GHImageButton(
                    imageModifier = Modifier.size(18.dp),
                    imageColorFilter = ColorFilter.tint(Gray70),
                    onClick = { passwordVisibility = !passwordVisibility },
                    imageResId = if(passwordVisibility) R.drawable.icon_visible else R.drawable.icon_invisible,
                    imageDescriptionResId = R.string.password_visibility_toggle_button
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
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
        )
    }
}

@Preview(apiLevel = 33)
@Composable
fun GHEOutLinedPasswordFieldPreview() {
    GuestHouseTheme {
        GHOutLinedPasswordField(
            value = "",
            onValueChange = {},
        )
    }
}

