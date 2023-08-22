package com.example.latihan1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.latihan1.ui.theme.Latihan1Theme
import com.example.latihan1.ui.theme.TopBar

class Detail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Latihan1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    DetailScreen(navController)
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun DetailScreen(navController: NavController, modifier: Modifier = Modifier) {
    TopBar("Home", true, navController) // Pass the NavController to TopBar

    Column(
        modifier = modifier.padding(start = 10.dp, end = 10.dp ,top = 100.dp)
    ) {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In augue arcu, rhoncus eu rhoncus quis, consectetur consequat lectus. Mauris vel velit maximus, laoreet enim a, ultrices lorem. Nam commodo ac nisi sit amet pellentesque. Nulla facilisi. Proin ut justo convallis, efficitur odio quis, elementum ipsum. Vivamus ultrices massa in magna cursus, at eleifend lorem auctor. Pellentesque ut cursus dolor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque at sem iaculis neque varius ornare. !"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Latihan1Theme {
        DetailScreen(navController = rememberNavController())
    }
}