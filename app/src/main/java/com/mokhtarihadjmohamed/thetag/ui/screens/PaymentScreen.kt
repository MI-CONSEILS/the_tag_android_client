package com.mokhtarihadjmohamed.thetag.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.components.CustomButton
import com.mokhtarihadjmohamed.thetag.ui.components.CustomRadioButton
import com.mokhtarihadjmohamed.thetag.ui.components.IconPosition
import com.mokhtarihadjmohamed.thetag.ui.components.TopBar
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal

@Composable
fun PaymentScreen(navController: NavController) {
    var paymentSelected by remember { mutableStateOf("") }
    val listPayment = stringArrayResource(R.array.payments)

    Scaffold(
        containerColor = white_normal,
        topBar = {
            TopBar(title = "Payement") {
                navController.popBackStack()
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .drawBehind {
                        val strokeWidth = 2.dp.toPx()
                        drawLine(
                            color = grey_light,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = strokeWidth
                        )
                    }
                    .padding(16.dp),
            ) {
                CustomButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Payer",
                    background = black_normal,
                    textColor = white_normal
                ) {
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("showDialog", true)

                    navController.navigate("HomeScreen")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding() + 8.dp,
                bottom = innerPadding.calculateBottomPadding(),
                start = 8.dp,
                end = 8.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listPayment.map {
                CustomRadioButton(
                    title = it,
                    onClick = {
                        paymentSelected = it
                    },
                    selected = paymentSelected == it,
                    icon = when (it) {
                        "Paiement en caisse" -> R.drawable.paiement_en_caisse
                        "Google Pay" -> R.drawable.google_pay
                        "Apple Pay" -> R.drawable.apple_pay
                        "**** **** **** 0895" -> R.drawable.jcb_card
                        "**** **** **** 2259" -> R.drawable.master_card
                        else -> null
                    }
                )
            }
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                label = "Ajouter une carte",
                iconPosition = IconPosition.START,
                icon = R.drawable.outline_add_24,
                background = white_normal,
                borderColor = grey_light,
                borderRadios = 12,
                textColor = black_normal,
                textSize = 16
            ) {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    val nav = rememberNavController()
    PaymentScreen(nav)
}