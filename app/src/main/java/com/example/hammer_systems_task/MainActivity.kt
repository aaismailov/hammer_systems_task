package com.example.hammer_systems_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hammer_systems_task.ui.screens.cart.CartScreen
import com.example.hammer_systems_task.ui.screens.profile.ProfileScreen
import com.example.hammer_systems_task.ui.screens.menu.MenuScreen
import com.example.hammer_systems_task.ui.theme.Hammer_Systems_taskTheme
import com.example.hammer_systems_task.data.NavItems
import com.example.hammer_systems_task.ui.components.BottomBar
import com.example.hammer_systems_task.ui.components.TopBar
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Hammer_Systems_taskTheme {
                ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                    Scaffold(
                        topBar = {
                            TopBar()
                        },
                        bottomBar = {
                            BottomBar(navController = navController)
                        },
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
            startDestination = NavItems.Menu.route
        ) {
            composable(NavItems.Menu.route) {
                MenuScreen(
                    navController = navController
                )
            }

            composable(NavItems.Profile.route) {
                ProfileScreen(
                    navController = navController
                )
            }

            composable(NavItems.Cart.route) {
                CartScreen(
                    navController = navController
                )
            }
        }
    }
}