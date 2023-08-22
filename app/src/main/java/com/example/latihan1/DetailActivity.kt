package com.example.latihan1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    val itemTitle = navController.currentBackStackEntry?.arguments?.getString("itemTitle") ?: ""
    val description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In augue arcu, rhoncus eu rhoncus quis, consectetur consequat lectus..."

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 90.dp, start = 10.dp, end = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            RoundedBoxWithTitle(itemTitle)
            Spacer(modifier = Modifier.height(8.dp))
            RoundedBoxWithDescription(description)
        }
    }
}

@Composable
fun RoundedBoxWithTitle(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp)) // Adjust the corner radius as needed
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun RoundedBoxWithDescription(description: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp)) // Adjust the corner radius as needed
    ) {
        Text(
            text = description,
            style = TextStyle(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.padding(8.dp)
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