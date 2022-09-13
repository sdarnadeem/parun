package dev.nasyxnadeem.parun.screens.signin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.nasyxnadeem.parun.model.SigninData
import dev.nasyxnadeem.parun.navigation.ParunScreens
import dev.nasyxnadeem.parun.screens.signup.SignupViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SigninScreen(navController: NavHostController, viewModel: SigninViewModel = hiltViewModel()) {



    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        val error: MutableState<String?> = rememberSaveable { mutableStateOf(null) }
        val keyboardController = LocalSoftwareKeyboardController.current

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Signup",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()})
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (!error.value.isNullOrEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 70.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text("*${error.value}", color = Color.Red)
            }
        }

        if (!viewModel.loading.value) {
            Button(
                onClick = {
                    validateInputs(email, password, error, viewModel)
                },
                modifier = Modifier.fillMaxWidth(0.7f).clip(shape = RoundedCornerShape(10.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff0124fb))
            ) {
                Text("Continue", color = Color.LightGray)
            }
        } else {
            CircularProgressIndicator()
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text("Don't have an account, ", style = MaterialTheme.typography.subtitle1)
            TextButton(onClick = {
                navController.navigate(ParunScreens.SignupScreen.name)
            }) {
                Text("Sign Up", style = MaterialTheme.typography.subtitle1)
            }
        }
    }
}

fun validateInputs(email: String, password: String,  error: MutableState<String?>, viewModel: SigninViewModel) {
    error.value = null
    if (email.trim().isEmpty()) {
        error.value = "Please Enter an email address"
    } else if (password.trim().isEmpty()) {
        error.value = "Please enter a password"
    } else {
        viewModel.signinUser(SigninData(email, password))

        if (!viewModel.data.value?.message.isNullOrEmpty()) {
            error.value = viewModel.data.value?.message
        } else if (!viewModel.e.value?.message.isNullOrEmpty()) {
            error.value = viewModel.e.value?.message
        } else {
            error.value = null
        }
    }

    }
