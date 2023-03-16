package com.example.migratingfromxmltocompose.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.migratingfromxmltocompose.R
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.example.migratingfromxmltocompose.sale.model.ForSaleItem


@Composable
fun MyCardView(item: ForSaleItem) {
    Card(
        modifier = Modifier
            .width(250.dp)
            .height(390.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 30.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.img_dron_item_home),
                contentDescription = item.label,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .weight(1f)
            )
            Text(
                text = item.label,
                fontSize = 27.sp,
                fontWeight = FontWeight.Black,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.nunito_black)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .paddingFromBaseline(top = 16.dp, bottom = 8.dp)
            )
            Text(
                text = item.description,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF555555),
                modifier = Modifier
                    .paddingFromBaseline(bottom = 30.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp)
            )
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFE8400)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxSize()
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

