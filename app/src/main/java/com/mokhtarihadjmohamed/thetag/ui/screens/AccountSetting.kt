package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomTextField
import com.mokhtarihadjmohamed.thetag.ui.components.IconPosition
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal
import kotlinx.coroutines.flow.flow

@Composable
fun AccountSetting(navController: NavController) {
    Scaffold(
        containerColor = black_normal,
        topBar = {
            TopBar(
                title = stringResource(R.string.accountSetting_title),
                iconColor = white_normal,
                textColor = white_normal,
                textSize = 18
            ) { }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = innerPadding.calculateBottomPadding()
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                title = "Nom",
                value = "Bennaceur",
                onValueChange = {},
                placeholder = "exemple@gmail.com",
                endIcon = R.drawable.edit,
                iconColor = grey_light_active,
                textSize = 12,
                enabled = false,
                onClickEndIcon = {

                }
            )
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                title = "Prénom",
                value = "Bennaceur",
                onValueChange = {},
                placeholder = "exemple@gmail.com",
                endIcon = R.drawable.edit,
                iconColor = grey_light_active,
                textSize = 12,
                enabled = false,
                onClickEndIcon = {

                }
            )
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                title = "Adresse e-mail ",
                value = "Bennaceur",
                onValueChange = {},
                placeholder = "exemple@gmail.com",
                endIcon = R.drawable.edit,
                iconColor = grey_light_active,
                textSize = 12,
                enabled = false,
                onClickEndIcon = {

                }
            )
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                title = "Numéro de téléphone ",
                value = "0758247144",
                onValueChange = {},
                placeholder = "exemple@gmail.com",
                endIcon = R.drawable.edit,
                iconColor = grey_light_active,
                textSize = 12,
                enabled = false,
                onClickEndIcon = {

                }
            )
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                title = "Mot de passe",
                value = "*********",
                onValueChange = {},
                placeholder = "exemple@gmail.com",
                endIcon = R.drawable.edit,
                iconColor = grey_light_active,
                textSize = 12,
                enabled = false,
                onClickEndIcon = {

                }
            )
            CustomTextField(
                modifier = Modifier
                    .border(
                        1.dp, grey_light_active, RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                title = "Adresse postal",
                value = "11bd victor wesrtyik 89472",
                onValueChange = {},
                placeholder = "exemple@gmail.com",
                endIcon = R.drawable.edit,
                iconColor = grey_light_active,
                textSize = 12,
                enabled = false,
                onClickEndIcon = {

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.accountSetting_logout),
                iconPosition = IconPosition.START,
                borderColor = grey_normal,
                borderRadios = 12,
            ) {
                navController.navigate("LogInScreen"){
                    popUpTo("AccountSetting") { inclusive = true }
                    launchSingleTop = true
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountSettingPreview() {
    AccountSetting(rememberNavController())
}