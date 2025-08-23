package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/*
* This Composable is Custom text field is user in multiple on like search normal textfield
* is tack as input icon and icon end evey icon can be change from input
* and had label and activate just when text is here
* */

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    textColor: Color = black_normal,
    placeholder: String = "Enter text",
    placeholderColor: Color = grey_dark,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    label: String? = null,
    labelBackground: Color = black_normal,
    labelColor: Color = white_normal,
    icon: Int? = null,
    iconColor: Color = grey_dark,
    endIcon: Int? = null,
    textAlign: TextAlign = TextAlign.Start,
) {

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
                    tint = iconColor
                )
            BasicTextField(
                modifier = Modifier.weight(1f),
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                keyboardOptions = keyboardOptions,
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
            if (endIcon != null)
                Icon(
                    painter = painterResource(endIcon),
                    contentDescription = "card icon",
                    modifier = Modifier
                        .size(21.dp),
                    tint = iconColor
                )
        }
    }

    if (label != null) {
        Box(
            modifier = Modifier
                .padding(start = 16.dp)       // position over left edge
                .offset(y = (-6).dp)          // lift above border line
                .background(labelBackground)     // hide border behind text
        ) {
            Text(
                text = label,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = labelColor,
                    fontWeight = FontWeight.Medium,
                ),
                modifier = Modifier.padding(horizontal = 4.dp) // spacing inside cut-out
            )
        }
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    titleSize: Int = 16,
    textSize: Int = 16,
    placeholder: String = "Enter text",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    textAlign: TextAlign = TextAlign.Start,
    icon: Int? = null,
    iconColor: Color = grey_dark,
    endIcon: Int? = null,
    enabled: Boolean = true,
    onClickEndIcon: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = title, style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = titleSize.sp,
                color = Color.White,
            )
        )
        Box(
            modifier = modifier
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                if (icon != null)
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = "card icon",
                        modifier = Modifier
                            .size(21.dp),
                        tint = iconColor
                    )
                BasicTextField(
                    modifier = Modifier.weight(1f),
                    value = value,
                    onValueChange = onValueChange,
                    enabled = enabled,
                    singleLine = true,
                    keyboardOptions = keyboardOptions,
                    textStyle = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = textSize.sp,
                        color = Color.White,
                        textAlign = textAlign
                    ),
                    decorationBox = { innerTextField ->
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder, style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                                    fontSize = textSize.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xffABA8AC),
                                )
                            )
                        }
                        innerTextField()
                    }
                )
                if (endIcon != null)
                    Icon(
                        painter = painterResource(endIcon),
                        contentDescription = "card icon",
                        modifier = Modifier
                            .size(21.dp)
                            .clickable(
                                onClick = onClickEndIcon
                            ),
                        tint = iconColor,
                    )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    var email by remember { mutableStateOf("") }
    CustomTextField(
        modifier = Modifier
            .border(
                1.dp, grey_light_active, RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 14.dp),
        value = email,
        onValueChange = {
            email = it
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        placeholder = "exemple@gmail.com",
    )
}