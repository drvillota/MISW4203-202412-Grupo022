package com.example.vinilosapp.ui.Screens

import com.example.vinilosapp.ui.theme.VinilosAppTheme


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vinilosapp.R
import com.example.vinilosapp.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel? = null,
    onNavToAlbumsPage: () -> Unit,
) {
    //val homeUiState = homeViewModel?.homeUiState
    //val isError = homeUiState?.loginError != null
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize() // Fills the entire screen
            .padding(horizontal = 16.dp), // Padding around content
        verticalArrangement = Arrangement.Center, // Center content vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_foreground), // Replace with your icon resource
            contentDescription = "Vinilos App Icon",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Vinilos App",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(8.dp)
        )
        Button(
            onClick = { onNavToAlbumsPage.invoke() },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White
            ),
        ) {
            Text(text = "Comienza")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevHomeScreen() {
    VinilosAppTheme {
        HomeScreen(onNavToAlbumsPage = { /*TODO*/ })
    }
}
















