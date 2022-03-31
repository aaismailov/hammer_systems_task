package com.example.hammer_systems_task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavScreen(
    val route: String,
    val caption: String,
    val icon: ImageVector
) {
    object Menu : NavScreen(
        route = "menu",
        caption = "Меню",
        icon = Icons.Default.Home
    )

    object Profile : NavScreen(
        route = "profile",
        caption = "Профиль",
        icon = Icons.Default.Person
    )

    object Cart : NavScreen(
        route = "cart",
        caption = "Корзина",
        icon = Icons.Default.Settings
    )
}
