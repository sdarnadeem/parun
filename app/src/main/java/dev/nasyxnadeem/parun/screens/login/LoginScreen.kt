package dev.nasyxnadeem.parun.screens.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.nasyxnadeem.parun.R

@Preview
@Composable
fun LoginScreen(navController: NavHostController? = null) {


    Column(modifier = Modifier.fillMaxSize().padding(top = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        var email by remember{ mutableStateOf("")}
        var password by remember{mutableStateOf("")}
        var mobileNumber by remember { mutableStateOf("") }
        var confirmPassword by remember {mutableStateOf("")}
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        var error by rememberSaveable {mutableStateOf("")}
        Image(
            painter = painterResource(R.drawable.login),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight(0.2f).fillMaxWidth(), contentScale = ContentScale.FillWidth
        )

Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp, vertical = 10.dp ), horizontalArrangement = Arrangement.Start) {
    Text(text = "Signup", color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)

}
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.AlternateEmail, contentDescription = null, tint = Color.Blue)
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = email,
                label = { Text(text = "Email Address") },
                onValueChange = {email = it},
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Phone, contentDescription = null, tint = Color.Blue)
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = mobileNumber,
                label = { Text(text = "Mobile Number") },
                onValueChange = {mobileNumber = it},
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Password, contentDescription = null, tint = Color.Blue)
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = password,
                label = { Text(text = "Password") },
                onValueChange = {password = it},
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.VisibilityOff
                    else Icons.Filled.Visibility

                    IconButton(onClick = {passwordVisible = !passwordVisible}) {
                        Icon(imageVector = image, contentDescription = null, tint = Color.Blue)
                    }

                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Password, contentDescription = null, tint = Color.Blue)
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                value = confirmPassword,
                label = { Text(text = "Confirm Password") },
                onValueChange = {confirmPassword = it},
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "An error occured")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth(0.7f).clip(shape = RoundedCornerShape(10.dp)), colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff0124fb))) {
            Text("Continue")
        }

    }
}

