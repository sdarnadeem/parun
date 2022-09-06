package dev.nasyxnadeem.parun.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue



import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.nasyxnadeem.parun.R

@Preview
@Composable
fun LoginScreen(navController: NavHostController? = null) {


    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        var email by remember{ mutableStateOf("")}
        var password by remember{mutableStateOf("")}
        var mobileNumber by remember { mutableStateOf("") }
        var confirmPassword by remember {mutableStateOf("")}
        Image(
            painter = painterResource(R.drawable.login),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight(0.3f)
        )

Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp, vertical = 20.dp ), horizontalArrangement = Arrangement.Start) {
    Text(text = "Signup", color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)

}
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.AlternateEmail, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = email,
                label = { Text(text = "Email Address") },
                onValueChange = {email = it},
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Phone, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = mobileNumber,
                label = { Text(text = "Mobile Number") },
                onValueChange = {mobileNumber = it},
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Password, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = password,
                label = { Text(text = "Password") },
                onValueChange = {password = it},
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Visibility, contentDescription = null)
                }
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Password, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = confirmPassword,
                label = { Text(text = "Confirm Password") },
                onValueChange = {confirmPassword = it},
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Visibility, contentDescription = null)
                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth(0.7f).clip(shape = RoundedCornerShape(10.dp)), colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff0124fb))) {
            Text("Continue")
        }

    }
}

