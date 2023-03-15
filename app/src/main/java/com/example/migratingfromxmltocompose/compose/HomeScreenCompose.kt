package com.example.migratingfromxmltocompose.compose

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "DRONE", color = Color.Black) },
                backgroundColor = Color.White,
                elevation = 4.dp,
                actions = {
                    IconButton(onClick = { /* TODO: Handle menu click */ }) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Red)
                    }
                    IconButton(onClick = { /* TODO: Handle search click */ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* TODO: Handle notifications click */ }) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                }
            )
        }
    ) {
        HomeFragment()
    }
}

@Composable
fun HomeFragment() {
    // TODO: Add your HomeFragment content here
}

@Preview
@Composable
fun HomeScreenPreview(){
    MaterialTheme {
        HomeScreen()
    }

}
