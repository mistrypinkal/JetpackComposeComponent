package com.pm.jetpackcomposecomponent.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pm.jetpackcomposecomponent.R
import com.pm.jetpackcomposecomponent.ui.theme.JetpackComposeComponentTheme

class ImageCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val pinter = painterResource(id = R.drawable.image)
            val description = "Content description"
            val title = "Title Card"
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)) {
                Column(modifier = Modifier.padding(10.dp)) {
                    ImageCard(painter = pinter, contentDescription = description, title = title)
                    Spacer(modifier = Modifier.height(10.dp))
                    ImageCard(painter = pinter, contentDescription = description, title = title)
                    Spacer(modifier = Modifier.height(10.dp))
                    ImageCard(painter = pinter, contentDescription = description, title = title)
                }

            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                ))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeComponentTheme {
        val pinter = painterResource(id = R.drawable.image)
        val description = "Content description"
        val title = "Title Card"
        Box(modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp)) {
            ImageCard(painter = pinter, contentDescription = description, title = title)
        }
    }
}