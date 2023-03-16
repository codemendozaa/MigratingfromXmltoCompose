package com.example.migratingfromxmltocompose.compose


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.migratingfromxmltocompose.sale.model.ForSaleItem

@Composable
fun ItemsToSaleList(items: List<ForSaleItem>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
    ) {
        items(items) { item ->
            MyCardView(item)
        }
    }
}