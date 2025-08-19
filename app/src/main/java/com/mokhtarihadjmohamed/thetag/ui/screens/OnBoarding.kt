package com.mokhtarihadjmohamed.thetag.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
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
import com.mokhtarihadjmohamed.thetag.ui.components.DotsNavigation
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_dark
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal
import kotlinx.coroutines.launch


/*
* This is for on boarding it have pager and box to
* show the image and when user scroll image change.
* */
@Composable
fun OnBoarding(navController: NavController) {
    val pagerState = rememberPagerState(pageCount = { 4 })
    val coroutineScope = rememberCoroutineScope()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(onHorizontalDrag = { _, dragAmount ->
                        Log.d("show offset", dragAmount.toString())
                    }, onDragEnd = {
                        val nextPage = pagerState.currentPage + 1
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(nextPage)
                        }
                    })
                },
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_page01),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .padding(
                        bottom = innerPadding.calculateBottomPadding(),
                        top = innerPadding.calculateTopPadding(),
                        end = 16.dp,
                        start = 16.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(modifier = Modifier.weight(3f))
                HorizontalPager(
                    modifier = Modifier.weight(2f),
                    state = pagerState
                ) { page ->
                    when (page) {
                        0 -> Page01()
                        1 -> Page02()
                        2 -> Page03()
                        3 -> Page04()
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CustomButton(
                        modifier = Modifier.weight(3f),
                        label = "S'inscrire",
                        background = white_normal,
                        textColor = black_normal,
                        borderRadios = 18
                    ) {
                        navController.navigate("RegisterScreen")
                    }

                    CustomButton(
                        modifier = Modifier.weight(3f),
                        label = "Se connecter",
                        background = Color.Transparent,
                        borderColor = white_normal,
                        textColor = white_normal,
                        borderRadios = 18
                    ) {
                        navController.navigate("LogInScreen")
                    }

                    Spacer(
                        modifier = Modifier.weight(
                            1f
                        )
                    )

                    DotsNavigation(
                        modifier = Modifier.weight(1f),
                        size = 4,
                        selected = pagerState.currentPage,
                        space = 4
                    )
                }
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "je suis professionnel",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = white_normal
                    )
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Licensed By the tag",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 14.sp,
                        color = white_normal,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }

    }
}

@Composable
fun Page01() {
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Touchez, découvrez, profitez",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 58.sp,
                fontWeight = FontWeight.Bold,
                color = white_normal
            )
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun Page02() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Un simple geste suffit.",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = white_normal
            )
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Touchez un tag avec votre smartphone pour accéder instantanément aux services d’un établissement.",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 16.sp,
                color = white_normal
            )
        )
    }
}

@Composable
fun Page03() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Fast-food ? Encore plus rapide.",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = white_normal
            )
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Touchez un tag, accédez au menu, commandez et récupérez — sans attendre.",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 16.sp,
                color = white_normal
            )
        )
    }
}

@Composable
fun Page04() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Restaurant ? Plus besoin d’attendre.",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = white_normal
            )
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Consultez le menu, appelez un serveur, demandez l’addition… tout depuis votre téléphone.",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontSize = 16.sp,
                color = white_normal
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    val navController = rememberNavController()
    OnBoarding(navController)
}