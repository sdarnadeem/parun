package dev.nasyxnadeem.parun.screens.splash

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.nasyxnadeem.parun.navigation.ParunScreens


@Composable
fun SplashScreen(navController: NavController) {

    val color = remember { Animatable(Color.Black) }

    // animate to red
    LaunchedEffect(true) {
        color.animateTo(Color.Magenta, animationSpec = tween(2000))
        navController.navigate(ParunScreens.LoginScreen.name)
    }

    val primaryTextStyle = TextStyle(
        color = color.value,
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
            Text("Make your move now", style = secondaryTextStyle,)
        }
    }
}

