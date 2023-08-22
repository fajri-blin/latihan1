package com.example.latihan1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.latihan1.ui.theme.Latihan1Theme
import com.example.latihan1.ui.theme.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Latihan1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation() // Use AppNavigation here
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController, modifier: Modifier = Modifier) {
    val imageResource = painterResource(id = R.drawable.ic_launcher_foreground)

    // State variables to store the user input
    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    // Creating a variable to store toggle state
    var passwordVisible = remember { mutableStateOf(false) }
    TopBar("Login")
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        Image(
            painter = imageResource,
            contentDescription = null, // Provide a meaningful description
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = usernameState.value,
            onValueChange = { usernameState.value = it },
            label = { Text(text = "Username") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text(text = "Password") },
            singleLine = true,
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible.value)
                    Icons.Default.Visibility
                else Icons.Default.VisibilityOff

                // Localized description for accessibility services
                val description = if (passwordVisible.value) "Hide password" else "Show password"

                // Toggle button to hide or display password
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate(Screen.Home.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Latihan1Theme {
        LoginPage(navController = rememberNavController())
    }
}
