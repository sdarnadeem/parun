package dev.nasyxnadeem.parun.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import dev.nasyxnadeem.parun.R

@Preview
@Composable
fun LoginScreen(navController: NavHostController? = null) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(R.drawable.login), contentDescription = null)

        TextField(value = "Hello", onValueChange = {})
    }
}