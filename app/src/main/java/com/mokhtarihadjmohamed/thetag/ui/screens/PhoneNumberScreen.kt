package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomDivider
import com.mokhtarihadjmohamed.thetag.ui.components.CustomPhoneNumber
import com.mokhtarihadjmohamed.thetag.ui.components.CustomTextClick
import com.mokhtarihadjmohamed.thetag.ui.components.CustomTextField
import com.mokhtarihadjmohamed.thetag.ui.components.IconPosition
import com.mokhtarihadjmohamed.thetag.ui.components.PasswordTextField
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

/**
 * This composable is an simple phone number screen it is where you put
 * you phone number to send you code to confirmed you phone number or rest
 * a password.
 * */

@Composable
fun PhoneNumberScreen(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("") }
    var selectedCode by remember { mutableStateOf("+1") }

    Scaffold(
        containerColor = black_normal,
        topBar = {
            TopBar(title = "", iconColor = white_normal) {
                navController.popBackStack()
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding() + 16.dp,
                    bottom = innerPadding.calculateBottomPadding() + 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            verticalArrangement = Arrangement.spacedBy(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.phoneNumber_title),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = white_normal
                )
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.phoneNumber_des),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 14.sp,
                    color = white_normal
                )
            )
            CustomPhoneNumber(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                value = phoneNumber,
                onValueChange = {
                    phoneNumber = it
                },
                label = "Phone Number",
                placeholder = "12345678",
                textColor = white_normal,
                onCodeSelected = { selected ->
                    selectedCode = selected
                }
            )

            Spacer(modifier = Modifier.weight(1f))
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.login_btn),
                background = white_normal,
                textColor = black_normal,
            ) {
                navController.navigate("OtpScreen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhoneNumberScreenPreview() {
    PhoneNumberScreen(rememberNavController())
}