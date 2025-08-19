package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal


/**
 * This Compose is just a line with text on it
 */

@Composable
fun CustomDivider(
    modifier: Modifier = Modifier,
    text: String? = null,
    thickness: Dp = 1.dp,
    color: Color = grey_light,
    textColor: Color = white_normal,
    textBackground: Color = black_normal
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        HorizontalDivider(
            thickness = thickness,
            color = color
        )
        if (text.isNullOrBlank())
            Text(
                modifier = Modifier
                    .background(textBackground)
                    .padding(start = 8.dp, end = 8.dp),
                text = stringResource(R.string.hrz_text),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 12.sp,
                    color = textColor,
                    textAlign = TextAlign.Center
                )
            )
    }
}