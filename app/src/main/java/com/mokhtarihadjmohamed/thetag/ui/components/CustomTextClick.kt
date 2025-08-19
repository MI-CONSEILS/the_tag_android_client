package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/**
 * This composable is just text click to help for make other code shorter so here will see just text
 * can be clicked and can put in front of it simple text to tall what this you will see
 * this in register and login
 * */

@Composable
fun CustomTextClick(
    modifier: Modifier = Modifier,
    title: String? = null,
    titleSize: Int = 14,
    titleColor: Color = white_normal,
    clickableText: String,
    textAlign: TextAlign = TextAlign.Center,
    textSize: Int = 14,
    textColor: Color = white_normal,
    titlePosition: TitlePosition = TitlePosition.TOP,
    onClick: () -> Unit
) {
    if (titlePosition == TitlePosition.TOP)
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (title != null)
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = titleSize.sp,
                        textAlign = textAlign,
                        color = titleColor
                    )
                )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        onClick = onClick
                    ),
                text = clickableText,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = textSize.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = textAlign,
                    color = white_normal
                )
            )
        }
    else
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (title != null)
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = titleSize.sp,
                        textAlign = textAlign,
                        color = titleColor
                    )
                )
            Text(
                modifier = Modifier
                    .clickable(
                        onClick = onClick
                    ),
                text = clickableText,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = textSize.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = textAlign,
                    color = textColor
                )
            )
        }
}

enum class TitlePosition { TOP, START }
