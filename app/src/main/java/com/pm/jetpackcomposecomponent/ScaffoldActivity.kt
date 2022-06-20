package com.pm.jetpackcomposecomponent

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pm.jetpackcomposecomponent.ui.theme.JetpackComposeComponentTheme

/**
 * Scaffold(
topBar = { //your top bar  },
floatingActionButton = {//your floating action button},
drawerContent = { //drawer content },
content = { //your page content},
bottomBar = { //your bottom bar composable }
)
 */
class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldSample()
        }
    }
}

@Composable
fun ScaffoldSample() {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Jetpack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Navigation back"
                        )
                    }
                },
                elevation = 10.dp,
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
            }
        },
        drawerContent = {
            Text(text = "Drawer menu 1")
        },
        content = { Text(text = "Content") },
        bottomBar = {
            BottomAppBar(backgroundColor = MaterialTheme.colors.primary) {
                Text(text = "Bottom App Bar")
            }
        }
    )
}

@Composable
fun TopAppBarCompose() {
    TopAppBar(
        title = {
            Text(text = "Jetpack Compose Example2")
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Navigation back"
                )
            }
        },
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Composable
fun BottomAppBarCompose() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 10.dp
    ) {

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text(text = "Home") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            }
        )

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Account") },
            label = { Text(text = "Account") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            }
        )

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite") },
            label = { Text(text = "Favorite") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            }
        )

    }
}

@Composable
fun ScaffoldTopBarWithBottom() {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBarCompose()
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
            }
        },
        drawerContent = {
            Text(text = "Drawer menu 1")
        },
        content = { Text(text = "Content") },
        bottomBar = {
            BottomAppBarCompose()
        }
    )
}


@Composable
fun ScaffoldTopBarWithBottom2() {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBarCompose()
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
            }
        },
        drawerContent = {
            Text(text = "Drawer menu 1")
        },
        content = { Text(text = "Content") },
        bottomBar = {
            BottomAppBarCompose()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ScaffoldSamplePreview() {
    JetpackComposeComponentTheme {
        ScaffoldSample()
    }
}

@Preview(
    name = "Light preview",
    showBackground = true)
@Preview(
    name ="Dark Preview",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun ScaffoldTopBarWithBottomPreview() {
    JetpackComposeComponentTheme {
        ScaffoldTopBarWithBottom()
    }
}


@Preview(showBackground = true)
@Composable
fun ScaffoldTopBarWithBottomPreview2() {
    JetpackComposeComponentTheme {
        ScaffoldTopBarWithBottom2()
    }
}

