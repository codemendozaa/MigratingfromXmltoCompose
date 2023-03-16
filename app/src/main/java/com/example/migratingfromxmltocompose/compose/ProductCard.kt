@file:OptIn(ExperimentalComposeUiApi::class)
package com.example.migratingfromxmltocompose.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.migratingfromxmltocompose.R
import com.example.migratingfromxmltocompose.sale.model.ForSaleItem


@Composable
fun MyCardView(item: ForSaleItem) {
    ConstraintLayout {
        val (card, image) = createRefs()
        Image(
            painter = painterResource(R.drawable.img_dron_item_home),
            contentDescription = item.label,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .zIndex(1f)
                .clip(RoundedCornerShape(15.dp))
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        Card(
            modifier = Modifier
                .width(270.dp)
                .height(390.dp)
                .constrainAs(card) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            shape = RoundedCornerShape(20.dp),
            elevation = 30.dp
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.label,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.nunito_black)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Text(
                    text = item.description,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    color = Color(0xFF555555),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 20.dp)
                )
                Button(
                    onClick = { /* TODO */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFE8400)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 20.dp)
                        .width(220.dp)
                        .height(60.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                    ) {
                        Text(
                            text = item.price,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                        Image(
                            painter = painterResource(id = R.drawable.icon_right_arrow),
                            contentDescription = "Arrow",
                            colorFilter = ColorFilter.tint(Color.White),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyComposePreview() {
    MyCardView(
        ForSaleItem(
            "PANTERA 4K",
            "With GPS, WiFi, FPV and Optical \\n Flow Stability",
            "$399.0",
            R.drawable.img_dron_item_home
        )
    )
}