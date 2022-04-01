package com.example.hammer_systems_task.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItems(
    val route: String,
    val caption: String,
    val icon: ImageVector
) {
    object Menu : NavItems(
        route = "menu",
        caption = "Меню",
        icon = Icons.Default.Home
    )

    object Profile : NavItems(
        route = "profile",
        caption = "Профиль",
        icon = Icons.Default.Person
    )

    object Cart : NavItems(
        route = "cart",
        caption = "Корзина",
        icon = Icons.Default.Settings
    )
}
