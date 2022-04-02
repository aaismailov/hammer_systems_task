package com.example.hammer_systems_task.data

import com.example.hammer_systems_task.R

sealed class NavItems(
    val route: String,
    val caption: String,
    val icon: Int
) {
    object Menu : NavItems(
        route = "menu",
        caption = "Меню",
        icon = R.drawable.ic_menu
    )

    object Profile : NavItems(
        route = "profile",
        caption = "Профиль",
        icon = R.drawable.ic_profile
    )

    object Cart : NavItems(
        route = "cart",
        caption = "Корзина",
        icon = R.drawable.ic_cart
    )
}
