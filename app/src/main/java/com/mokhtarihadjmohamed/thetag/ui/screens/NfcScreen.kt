package com.mokhtarihadjmohamed.thetag.ui.screens

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomVideoPlayer
import com.mokhtarihadjmohamed.thetag.ui.components.IconPosition
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun NfcScreen(navController: NavController) {

    Scaffold(
        containerColor = black_normal,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier
                        .clickable(onClick = {
                            navController.navigate("NfcScreen")
                        })
                        .weight(1f)
                        .drawBehind {
                            val strokeWidth = 2.dp.toPx()
                            drawLine(
                                color = white_normal,
                                start = androidx.compose.ui.geometry.Offset(0f, size.height),
                                end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                                strokeWidth = strokeWidth
                            )
                        }
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp
                        ),
                    text = stringResource(R.string.nfcScreen_text_top_01),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = white_normal,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    modifier = Modifier
                        .clickable(onClick = {
                            navController.navigate("SearchEstablishmentScreen")
                        })
                        .weight(1f)
                        .drawBehind {
                            val strokeWidth = 2.dp.toPx()
                            drawLine(
                                color = black_normal,
                                start = androidx.compose.ui.geometry.Offset(0f, size.height),
                                end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                                strokeWidth = strokeWidth
                            )
                        }
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp
                        ),
                    text = stringResource(R.string.nfcScreen_text_top_02),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = grey_normal,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding() + 16.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = innerPadding.calculateBottomPadding() + 8.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.nfcScreen_title),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = white_normal,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.nfcScreen_dec),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 14.sp,
                    color = white_normal,
                    textAlign = TextAlign.Center
                )
            )

            CustomVideoPlayer(
                modifier = Modifier.weight(1f),
                videoRes = R.raw.nfc_loading,
                aspect = AspectRatioFrameLayout.RESIZE_MODE_FIT
            )

            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.nfcScreen_btn),
                iconPosition = IconPosition.START,
                icon = R.drawable.setting,
                borderColor = grey_normal,
                borderRadios = 12,
            ) { }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NfcScreenPreview() {
    NfcScreen(rememberNavController())
}