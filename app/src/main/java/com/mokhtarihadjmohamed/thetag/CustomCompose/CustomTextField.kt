package com.mokhtarihadjmohamed.thetag.CustomCompose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.View.HomeScreen
import com.mokhtarihadjmohamed.thetag.ui.theme.border_color
import com.mokhtarihadjmohamed.thetag.ui.theme.icon_color


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Enter text",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    icon: Int? = null,
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
                    tint = icon_color
                )
            BasicTextField(
                modifier= Modifier.weight(1f),
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = icon_color,
                    textAlign = textAlign
                ),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder, style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_medium)),
                                fontSize = 14.sp,
                                color = icon_color,
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
                    tint = icon_color
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposablePreviewCustomEditText(){
    var text by remember { mutableStateOf("") }

    CustomTextField(
        modifier = Modifier.border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(12.dp).fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
        },
        placeholder = stringResource(R.string.search) ,
        icon = R.drawable.search,
        endIcon = R.drawable.fillter
    )
}