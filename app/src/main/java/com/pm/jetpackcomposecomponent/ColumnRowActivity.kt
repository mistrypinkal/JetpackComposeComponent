package com.pm.jetpackcomposecomponent

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pm.jetpackcomposecomponent.ui.theme.JetpackComposeComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnFunction()
        }
    }
}

@Composable
fun ColumnFunction() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Pinkal Mistry!",
            fontSize = 30.sp,
            maxLines = 2,
            color = Color.White
        )
        Text(text = "Android Engineer!")
        Text(text = "UAE")
        ClickableText(text = AnnotatedString("View Profile"), onClick = {
            Log.d("TAG", "Profile click: ")
        })
    }

}

@Composable
fun RowFunction() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Red),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Pinkal Mistry!")
        Text(text = "Android Engineer!")
        Text(text = "UAE")
    }
}

@Preview(
    name = "Column preview",
    showBackground = true
)
@Composable
fun ColumnPreview() {
    JetpackComposeComponentTheme {
        ColumnFunction()
    }
}


@Preview(
    name = "Row preview",
    showBackground = true
)
@Composable
fun RowPreview() {
    JetpackComposeComponentTheme {
        RowFunction()
    }
}