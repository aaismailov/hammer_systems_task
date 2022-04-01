package com.example.hammer_systems_task.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hammer_systems_task.data.NavItems
import com.example.hammer_systems_task.ui.theme.Gray600
import com.example.hammer_systems_task.ui.theme.Pink400


@Composable
fun BottomBar(
    navController: NavHostController
) {
    val screens = listOf(
        NavItems.Menu,
        NavItems.Profile,
        NavItems.Cart
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                items = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    items: NavItems,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = items.caption)
        },
        icon = {
            Icon(
                imageVector = items.icon,
                contentDescription = null
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == items.route
        } == true,
        selectedContentColor = Pink400,
        unselectedContentColor = Gray600,
        onClick = {
            navController.navigate(items.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}