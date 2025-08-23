package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.CustomTextField
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun AccountEditInfo(navController: NavController) {
    Scaffold(
        containerColor = black_normal,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate("AccountSetting") {
                            popUpTo(0) { inclusive = true }
                            launchSingleTop = true
                        }
                    }),
                    text = stringResource(R.string.accountEdit_cancel),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 14.sp,
                        color = grey_light_active,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    text = stringResource(R.string.nameAuth),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 18.sp,
                        color = white_normal,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )
                Text(
                    modifier = Modifier.clickable(
                        onClick = {
                            navController.navigate("AccountSetting") {
                                popUpTo(0) { inclusive = true }
                                launchSingleTop = true
                            }
                        }
                    ),
                    text = stringResource(R.string.accountEdit_save),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 14.sp,
                        color = grey_light_active,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = innerPadding.calculateBottomPadding()
            )
        ) {

            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                title = stringResource(R.string.nameAuth),
                value = "",
                onValueChange = {},
                placeholder = stringResource(R.string.nameAuth),
                textSize = 12,
                onClickEndIcon = {

                }
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun AccountEditInfoPreview() {
    AccountEditInfo(rememberNavController())
}