package com.pm.jetpackcomposecomponent.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pm.jetpackcomposecomponent.ui.theme.JetpackComposeComponentTheme
import kotlinx.coroutines.launch

class TextFieldButtonComponent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldButton()
        }
    }
}

@Composable
fun TextFieldButton() {
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    var outlineTextFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            // Text field
            TextField(
                value = textFieldState,
                label = {
                    Text("Enter your name")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            // add space between component
            Spacer(modifier = Modifier.height(16.dp))

            // Outlined Text field
            OutlinedTextField(
                value = outlineTextFieldState,
                label = {
                    Text("Enter your OutlinedTextField name")
                },
                onValueChange = {
                    outlineTextFieldState = it
                },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )

            // add space between component
            Spacer(modifier = Modifier.height(16.dp))

            // button
            Button(
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Plz greet me")
            }

        }
    }
}

@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .padding(horizontal = 30.dp)
    ) {
        TextField(
            value = text,
            label = { Text(text = "Number Input Type") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { it ->
                text = it
            }
        )
    }
}

@Composable
fun TextFieldWithIcon() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .padding(horizontal = 30.dp)
    ) {
        TextField(
            value = text,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon"
                )
            },
            label = { Text(text = "Email Address") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = {
                text = it
            }
        )
    }
}

@Preview
@Composable
fun previewTextFieldButton() {
    JetpackComposeComponentTheme {
        TextFieldButton()
    }
}

@Preview
@Composable
fun previewTextFieldWithInputType() {
    JetpackComposeComponentTheme {
        TextFieldWithInputType()
    }
}

@Preview
@Composable
fun previewTextFieldWithIcon() {
    JetpackComposeComponentTheme {
        TextFieldWithIcon()
    }
}

