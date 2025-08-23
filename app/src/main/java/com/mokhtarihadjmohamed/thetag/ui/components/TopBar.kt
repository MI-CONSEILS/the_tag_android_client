package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark

/*
* This Composable is Top bar and it have logo name category and notification icon like cart
* and chat, it tack is input just the title.
* */

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    iconColor: Color = grey_dark,
    onChatClick: () -> Unit,
    onBasketClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            modifier = Modifier.size(32.dp),
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo"
        )
        Text(
            title,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        NotificationIconWithBadge(
            icon = painterResource(R.drawable.shooping_cart),
            hasNotification = true,
            onClick = onBasketClick,
            iconColor = iconColor,
            number = 4
        )

        NotificationIconWithBadge(
            icon = painterResource(R.drawable.chat),
            hasNotification = false,
            iconColor = iconColor,
            onClick = onChatClick,
        )

    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    iconColor: Color = black_normal,
    textColor: Color = black_normal,
    textSize: Int = 24,
    onclick: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CustomIconButton(
            icon = R.drawable.outline_arrow_back_24,
            borderWidth = 0,
            borderColor = Color.Transparent,
            iconSize = 24,
            iconColor = iconColor,
            onClick = onclick
        )
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = textSize.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = textColor
            )
        )
        Box(modifier = Modifier.size(24.dp))
    }
}
