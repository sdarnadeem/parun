package dev.nasyxnadeem.parun.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Preview(showBackground = true)
@Composable
fun SplashScreen(navController: NavController? = null) {
    val primaryTextStyle = TextStyle(
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        fontSize = 70.sp

    )

    val secondaryTextStyle = TextStyle(
        fontStyle = FontStyle.Italic,
        fontSize = 23.sp
    )
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffA5F1E9)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("PARUN", style = primaryTextStyle)
            Text("Make your move now", style = secondaryTextStyle)
        }
    }
}

