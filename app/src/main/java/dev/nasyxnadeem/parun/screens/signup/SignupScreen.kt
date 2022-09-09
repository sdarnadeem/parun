package dev.nasyxnadeem.parun.screens.signup


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.nasyxnadeem.parun.R
import dev.nasyxnadeem.parun.model.SignupData

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun SignupScreen(navController: NavHostController? = null, viewModel: SignupViewModel = hiltViewModel()) {


    Column(modifier = Modifier.fillMaxSize().padding(top = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        var email by remember{ mutableStateOf("")}
        var password by remember{mutableStateOf("")}
        var mobileNumber by remember { mutableStateOf("") }
        var confirmPassword by remember {mutableStateOf("")}
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        val error= rememberSaveable {mutableStateOf("")}
//        val loading = remember { mutableStateOf(false) }


//        println("SIGNUP SCREEN LOADING" + viewModel.data.value.loading)
        val keyboardController = LocalSoftwareKeyboardController.current
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                    validateInputs(email, mobileNumber, password, confirmPassword, error, viewModel)
                })
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (!error.value.isNullOrEmpty()) {
            Row(modifier = Modifier.fillMaxWidth().padding(start = 70.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
                Text("*${error.value}", color = Color.Red)
            }
        }

        if (!viewModel.loading.value) {
            Button(onClick = {
                validateInputs(email, mobileNumber, password, confirmPassword, error, viewModel)
            }, modifier = Modifier.fillMaxWidth(0.7f).clip(shape = RoundedCornerShape(10.dp)), colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff0124fb))) {
                Text("Continue", color = Color.LightGray)
            }
        } else {
            CircularProgressIndicator()
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text("Already have an account, ", style = MaterialTheme.typography.subtitle1)
            TextButton(onClick = {}) {
                Text("Sign In", style = MaterialTheme.typography.subtitle1)
            }
        }

    }
}


fun validateInputs(email: String, mobileNumber: String, password: String, confirmPassword: String, error: MutableState<String>, viewModel: SignupViewModel) {
//        if (email.isEmpty()) {
//            error.value = "Please Enter an Email"
//        } else if (mobileNumber.isEmpty()) {
//            error.value = "Please Enter a mobile Number"
//        } else if (password.isEmpty()) {
//            error.value = "Please enter a password"
//        } else if (password.length < 8) {
//            error.value = "Please enter a password containing at least 8 characters"
//        } else if (password != confirmPassword) {
//            error.value = "Password and confirm password must be same"
//        } else {
            error.value = ""
            viewModel.signupUser(signupData = SignupData(email, mobileNumber, password, confirmPassword))
            if (!viewModel.response.value?.message.isNullOrEmpty()) {
                error.value = viewModel.response.value?.message.toString()
            }
//        }


}

