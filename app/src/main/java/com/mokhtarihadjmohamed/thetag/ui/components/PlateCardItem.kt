package com.mokhtarihadjmohamed.thetag.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokhtarihadjmohamed.thetag.R
import com.mokhtarihadjmohamed.thetag.ui.theme.black_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_light_active
import com.mokhtarihadjmohamed.thetag.ui.theme.grey_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.red_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.white_normal
import com.mokhtarihadjmohamed.thetag.ui.theme.yellow_light

@Composable
fun PlateCardItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    roundedCorner: Int = 16,
    borderColor: Color? = null,
    textColor: Color = white_normal,
) {
    Box(
        modifier = modifier
            .padding(bottom = 36.dp)
    ) {
        Box(
            modifier = Modifier
                .shadow(
                    elevation = roundedCorner.dp,
                    spotColor = yellow_light,
                    shape = RoundedCornerShape(roundedCorner.dp),
                    clip = false
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(roundedCorner.dp))
                .then(
                    if (borderColor == null)
                        Modifier.border(
                            width = 2.dp,
                            brush = Brush.verticalGradient(
                                colors = listOf(white_normal, grey_normal),
                                startY = 0f,
                                endY = Float.POSITIVE_INFINITY
                            ),
                            shape = RoundedCornerShape(roundedCorner.dp)
                        )
                    else
                        Modifier.border(
                            width = 2.dp,
                            color = borderColor,
                            shape = RoundedCornerShape(roundedCorner.dp)
                        )
                )
        ) {
            Image(
                painter = painterResource(R.drawable.plate_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, black_normal.copy(.3f)),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    ),
                    shape = RoundedCornerShape(roundedCorner.dp)
                )
        )


        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.weight(8f))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                )
                Text(
                    text = "7.99$",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                )
            }

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = description,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 14.sp,
                    color = textColor
                )
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        CustomIconButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = -roundedCorner.dp, y = roundedCorner.dp),
            icon = R.drawable.favorite,
            iconColor = white_normal,
            iconSize = 24,
            background = red_normal,
            borderColor = white_normal,
            roundedCorner = 8,
            borderWidth = 2,
            paddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlateCardItemPreview() {
    PlateCardItem(
        title = "Entrecôte Grillée",
        description = "Un généreux assortiment de fruits de mer frais, composé de crevettes charnues, d’huîtres savoureuses, de langoustines délicates et d’un tourteau bien garni"
    )
}
