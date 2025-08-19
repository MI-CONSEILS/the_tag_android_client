package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/**
 * This Composable is just password text field if just have show and hide password functionality
 * the normal text field.
 * */

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    textColor: Color = black_normal,
    placeholder: String = "Enter text",
    placeholderColor: Color = grey_dark,
    label: String? = null,
    labelBackground: Color = black_normal,
    labelColor: Color = white_normal,
    icon: Int? = null,
    textAlign: TextAlign = TextAlign.Start,
) {

    var hide by remember {
        mutableStateOf(
            true
        )
    }

    Box() {
        Box(
            modifier = modifier,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                if (icon != null)
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = "card icon",
                        modifier = Modifier
                            .size(21.dp),
                        tint = grey_dark
                    )
                BasicTextField(
                    modifier = Modifier.weight(1f),
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    keyboardOptions =
                        KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (hide) PasswordVisualTransformation() else VisualTransformation.None,
                    textStyle = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 14.sp,
                        color = textColor,
                        textAlign = textAlign
                    ),
                    decorationBox = { innerTextField ->
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder, style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                                    fontSize = 14.sp,
                                    color = placeholderColor,
                                )
                            )
                        }
                        innerTextField()
                    }
                )
                CustomIconButton(
                    paddingValues = PaddingValues(0.dp),
                    icon = if (hide)
                        R.drawable.eye
                    else
                        R.drawable.eye_crossed,
                    borderColor = Color.Transparent,
                    iconColor = textColor
                ) {
                    if (hide)
                        hide = false
                    else
                        hide = true
                }

            }
        }

        if (label != null) {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .offset(y = (-6).dp)
                    .background(labelBackground)
            ) {
                Text(
                    text = label,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = labelColor,
                        fontWeight = FontWeight.Medium,
                    ),
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CustomTextFieldPassPreview() {
    var email by remember { mutableStateOf("") }
    PasswordTextField(
        modifier = Modifier
            .border(
                1.dp, grey_light_active, RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 14.dp),
        value = email,
        onValueChange = {
            email = it
        },
        placeholder = "exemple@gmail.com",
    )
}