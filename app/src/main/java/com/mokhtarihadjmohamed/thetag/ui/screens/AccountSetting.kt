package com.mokhtarihadjmohamed.thetag.ui.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.tagwatchproject.Viewmodels.AuthViewModel
import com.mokhtarihadjmohamed.tagwatchproject.Viewmodels.SettingsViewModel
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.data.datastore.SettingsDataStore
import com.mokhtarihadjmohamed.thetag.data.remote.RetrofitInstance
import com.mokhtarihadjmohamed.thetag.data.remote.entities.AuthResult
import com.mokhtarihadjmohamed.thetag.data.repository.AuthRepository
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomTextField
import com.mokhtarihadjmohamed.thetag.ui.components.IconPosition
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal
import kotlinx.coroutines.flow.flow

@Composable
fun AccountSetting(navController: NavController) {
    val context = LocalContext.current
    val dataStore = SettingsDataStore(context)

    val repository = AuthRepository(
        api = RetrofitInstance.apiService,
        dataStore = dataStore,
    )

    val viewModel: AuthViewModel = viewModel(
        factory = AuthViewModel.Factory(repository)
    )
    val authResult by viewModel.authResults.collectAsState(initial = null)

    LaunchedEffect(authResult) {
        when (authResult) {
            is AuthResult.Authorized -> {
                navController.navigate("OnBoarding") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }

            is AuthResult.Unauthorized -> {
                Toast.makeText(context, "You're not authorized", Toast.LENGTH_LONG).show()
            }

            is AuthResult.UnknownError -> {
                Toast.makeText(context, "An unknown error occurred", Toast.LENGTH_LONG).show()
            }

            else -> Unit
        }
    }

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
                title = stringResource(R.string.nameAuth),
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
                title = stringResource(R.string.familyNameAuth),
                value = "Bennaceur",
                onValueChange = {},
                placeholder = stringResource(R.string.familyNameAuth),
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
                title = stringResource(R.string.emailAuth),
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
                title = stringResource(R.string.phoneNumberAuth),
                value = "0758247144",
                onValueChange = {},
                placeholder = stringResource(R.string.phoneNumberAuth),
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
                title = stringResource(R.string.passwordAuth),
                value = "*********",
                onValueChange = {},
                placeholder = stringResource(R.string.passwordAuth),
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
                title = stringResource(R.string.adresseAuth),
                value = "11bd victor wesrtyik 89472",
                onValueChange = {},
                placeholder = stringResource(R.string.adresseAuth),
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
                viewModel.logout()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountSettingPreview() {
    AccountSetting(rememberNavController())
}