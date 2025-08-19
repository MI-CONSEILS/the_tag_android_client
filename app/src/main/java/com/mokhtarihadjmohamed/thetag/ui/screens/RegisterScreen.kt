package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomDivider
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
 * this is just register screen where will you find a text field
 * that will field by user to get his main information.
 * */

@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var familyName by remember { mutableStateOf("") }


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
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.register_title),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = white_normal
                )
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.register_dec),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 16.sp,
                    color = white_normal
                )
            )
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                textColor = white_normal,
                value = name,
                onValueChange = {
                    name = it
                },
                placeholder = stringResource(R.string.nameAuth),
                placeholderColor = grey_normal,
            )
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                textColor = white_normal,
                value = familyName,
                onValueChange = {
                    familyName = it
                },
                placeholder = stringResource(R.string.familyNameAuth),
                placeholderColor = grey_normal,
            )
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                textColor = white_normal,
                value = email,
                onValueChange = {
                    email = it
                },

                label = "email",
                placeholder = "exemple@gmail.com",
            )
            PasswordTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                textColor = white_normal,
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = stringResource(R.string.passwordAuth),
            )
            PasswordTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                textColor = white_normal,
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = stringResource(R.string.confirpasswordAuth),
            )
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.login_btn),
                background = white_normal,
                textColor = black_normal,
            ) { }
            CustomDivider()
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.login_btn_apple),
                icon = R.drawable.apple_pay,
                iconSize = 18,
                iconPosition = IconPosition.START,
                iconColor = white_normal,
                borderColor = grey_normal,
                borderRadios = 18,
                borderThinks = 1,
            ) { }
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
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(rememberNavController())
}