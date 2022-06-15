package com.pm.jetpackcomposecomponent.feature

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pm.jetpackcomposecomponent.ui.theme.JetpackComposeComponentTheme

class ModifiersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifiersFunction("Android")
        }
    }
}

@Composable
fun ModifiersFunction(name: String) {
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.7f)
            .requiredWidth(300.dp)
            .border(5.dp, Color.Magenta)
            .padding(5.dp)
            .border(5.dp, Color.Blue)
            .padding(5.dp)
            .border(5.dp, Color.Red)
            .padding(5.dp)
            .border(5.dp, Color.Blue)
    ) {
        Text(
            text = "Pinkal Mistry",
            modifier = Modifier.offset(10.dp,20.dp),
            fontSize = 22.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Modifiers Demo",
        modifier = Modifier
            .border(5.dp, Color.Yellow)
            .padding(5.dp))

        Text(text = "Click Demo", Modifier.clickable {
            Log.d("TAG", "ModifiersFunction: Click")
        })
    }
}

@Preview(
    name = "ModifiersFunction preview",
)
@Composable
fun DefaultPreview() {
    JetpackComposeComponentTheme {
        ModifiersFunction("Android")
    }
}