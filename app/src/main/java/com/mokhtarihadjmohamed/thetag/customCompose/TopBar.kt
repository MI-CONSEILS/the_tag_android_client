package com.mokhtarihadjmohamed.thetag.customCompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color

/*
* This Composable is Top bar and it have logo name category and notification icon like cart
* and chat, it tack is input just the title.
* */

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String
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
            onClick = {},
            number = 4
        )

        NotificationIconWithBadge(
            icon = painterResource(R.drawable.chat),
            hasNotification = false,
            onClick = {},
        )

    }
}
