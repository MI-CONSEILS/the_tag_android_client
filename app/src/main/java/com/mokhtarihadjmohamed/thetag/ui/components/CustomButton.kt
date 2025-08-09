package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.red_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.red_light
import com.mokhtarihadjmohamed.thetag.ui.theme.red_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/*
* This Composable is for my custom button it not have a lot in just a box and Text inside
* */
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    label: String,
    background: Color = black_normal,
    textColor: Color = white_normal,
    textSize: Int = 14,
    icon: Int? = null,
    iconPosition: IconPosition = IconPosition.TOP,
    borderColor: Color = Color.Transparent,
    borderRadios: Int = 4,
    padding: PaddingValues = PaddingValues(16.dp),
    onClick: () -> Unit,
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .border(2.dp, borderColor, RoundedCornerShape(borderRadios.dp))
            .background(background, RoundedCornerShape(borderRadios.dp))
            .clickable(onClick = onClick)
            .padding(padding)
    ) {
        if (iconPosition == IconPosition.TOP) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (icon != null) Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = textColor
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
                if (icon != null) Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = textColor
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
        label = "Ajouter 1 au panier | 14.65\$",
        icon = R.drawable.delete,
        background = red_normal.copy(alpha = .8f),
        borderColor = red_dark,
        textColor = white_normal
    ) { }

}