package com.example.hammer_systems_task.data

enum class FoodCategory(
    val value: String
) {
    PizzaCategory("Пицца"),
    ComboCategory("Комбо"),
    DessertCategory("Десерты"),
    DrinkCategory("Напитки")
}

fun getAllFoodCategories(): List<FoodCategory> {
    return listOf(
        FoodCategory.PizzaCategory,
        FoodCategory.ComboCategory,
        FoodCategory.DessertCategory,
        FoodCategory.DrinkCategory
    )
}

fun getFoodCategory(value: String): FoodCategory? {
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[value]
}