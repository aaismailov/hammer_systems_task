package com.example.hammer_systems_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hammer_systems_task.ui.screens.cart.CartScreen
import com.example.hammer_systems_task.ui.screens.cart.ProfileScreen
import com.example.hammer_systems_task.ui.screens.menu.MenuScreen
import com.example.hammer_systems_task.ui.theme.Hammer_Systems_taskTheme
import com.google.accompanist.insets.navigationBarsPadding
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Hammer_Systems_taskTheme {
                ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                    Scaffold(
                        bottomBar = { BottomBar(navController = navController) },
                        content = {
                            MainScreen(
                                navController = navController
                            )
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun BottomBar(
    navController: NavHostController
) {
    val screens = listOf(
        NavScreen.Menu,
        NavScreen.Profile,
        NavScreen.Cart
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: NavScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.caption)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@Composable
fun MainScreen(
    navController: NavHostController
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = NavScreen.Menu.route
        ) {
            composable(NavScreen.Menu.route) {
                MenuScreen(
                    navController = navController
                )
            }

            composable(NavScreen.Profile.route) {
                ProfileScreen(
                    navController = navController
                )
            }

            composable(NavScreen.Cart.route) {
                CartScreen(
                    navController = navController
                )
            }
        }
    }
}