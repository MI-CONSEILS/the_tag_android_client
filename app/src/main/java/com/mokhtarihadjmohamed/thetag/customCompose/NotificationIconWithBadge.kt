package com.mokhtarihadjmohamed.thetag.customCompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.background_color
import com.mokhtarihadjmohamed.thetag.ui.theme.icon_color


/*
* This Composable is Notification icon with badge this is tack
* enter icon and show badge if thar are notification
* */
@Composable
fun NotificationIconWithBadge(
    onClick: () -> Unit,
    hasNotification: Boolean,
    icon: Painter,
    contentDescription: String? = null,
    number: Int = 0
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clickable(onClick = onClick)
            .size(48.dp)
            .background(background_color, CircleShape)
            .padding(8.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(24.dp)
                .background(background_color, CircleShape),
            tint = icon_color
        )

        if (hasNotification) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color.Red, shape = CircleShape)
                    .align(Alignment.BottomEnd)
                    .absoluteOffset(x = 0.dp, y = (0).dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        number.toString(),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontSize = 6.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )
                }

            }
        }
    }
}
