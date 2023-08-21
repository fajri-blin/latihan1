package com.example.latihan1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    TopBar(page = "Detail")
                    DetailScreen()
                }
            }
        }
    }
}

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In augue arcu, rhoncus eu rhoncus quis, consectetur consequat lectus. Mauris vel velit maximus, laoreet enim a, ultrices lorem. Nam commodo ac nisi sit amet pellentesque. Nulla facilisi. Proin ut justo convallis, efficitur odio quis, elementum ipsum. Vivamus ultrices massa in magna cursus, at eleifend lorem auctor. Pellentesque ut cursus dolor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque at sem iaculis neque varius ornare. !",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Latihan1Theme {
        TopBar(page = "Detail")
        DetailScreen()
    }
}