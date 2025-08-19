package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/*
* This Composable is for my custom button it is a box and Text inside
* and we have icon when you see icon will see tow type off icon in start and in top
* and the top position and this is the default we use enum class is in the bottom in this file,
* this composable take icon like icon and image.
* */
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    label: String,
    background: Color = black_normal,
    textColor: Color = white_normal,
    textSize: Int = 14,
    icon: Int? = null,
    iconSize: Int = 24,
    iconPosition: IconPosition = IconPosition.TOP,
    iconColor: Color? = null,
    borderColor: Color = Color.Transparent,
    borderRadios: Int = 4,
    borderThinks: Int = 2,
    iconEnd: Int? = null,
    padding: PaddingValues = PaddingValues(16.dp),
    onClick: () -> Unit,
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .border(borderThinks.dp, borderColor, RoundedCornerShape(borderRadios.dp))
            .background(background, RoundedCornerShape(borderRadios.dp))
            .clickable(onClick = onClick)
            .padding(padding)
    ) {
        if (iconPosition == IconPosition.TOP) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (icon != null)
                    if (iconColor == null)
                        Image(
                            modifier = Modifier.size(iconSize.dp),
                            painter = painterResource(icon),
                            contentDescription = "logo btn",
                        )
                    else
                        Icon(
                            modifier = Modifier.size(iconSize.dp),
                            painter = painterResource(icon),
                            contentDescription = "logo btn",
                            tint = iconColor
                        )
                Text(
                    text = label,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = textSize.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = textColor
                    )
                )
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null)
                    if (iconColor == null)
                        Image(
                            modifier = Modifier.size(iconSize.dp),
                            painter = painterResource(icon),
                            contentDescription = "logo btn",
                        )
                    else
                        Icon(
                            modifier = Modifier.size(iconSize.dp),
                            painter = painterResource(icon),
                            contentDescription = "logo btn",
                            tint = iconColor
                        )
                Text(
                    text = label,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = textSize.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = textColor
                    )
                )
            }
        }
    }
}

enum class IconPosition { TOP, START }

@Preview(showBackground = true)
@Composable
fun PreviewCustomButton() {
    CustomButton(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(R.string.login_btn_google),
        icon = R.drawable.google_icon,
        iconSize = 18,
        iconPosition = IconPosition.START,
        borderColor = grey_normal,
        borderRadios = 18,
        borderThinks = 1
    ) { }

}