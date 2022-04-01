package com.example.hammer_systems_task.data

import com.example.hammer_systems_task.R

enum class FoodBanner(
    val image: Int
) {
    Banner1(R.drawable.ic_banner1),
    Banner2(R.drawable.ic_banner1),
    Banner3(R.drawable.ic_banner1)
}

fun getAllFoodBanners(): List<FoodBanner> {
    return listOf(
        FoodBanner.Banner1,
        FoodBanner.Banner2,
        FoodBanner.Banner3
    )
}

fun getFoodBanner(
    image: Int
    ): FoodBanner? {
    val map = FoodBanner.values().associateBy(FoodBanner::image)
    return map[image]
}