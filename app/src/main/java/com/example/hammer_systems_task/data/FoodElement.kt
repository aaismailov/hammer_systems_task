package com.example.hammer_systems_task.data

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.hammer_systems_task.R

enum class FoodElement(
    val title: String,
    val body: String,
    val image: Int,
    val price: String
) {
    Pizza1(
        "Ветчина и грибы",
        "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
        R.drawable.ic_buffalo,
        "от 345 р"
    ),
    Pizza2(
        "Баварские колбаски",
        "Баварские колбаски, ветчина,пикантная пепперони, острая чоризо,томатный соус",
        R.drawable.ic_buffalo,
        "от 345 р"
    ),
    Pizza3(
        "Нежный лосось",
        "Лосось, томаты, оливки,соус песто,помидорки черри",
        R.drawable.ic_buffalo,
        "от 345 р"
    ),
    Pizza4(
        "Нежный лосось",
        "Лосось, томаты, оливки,соус песто,помидорки черри",
        R.drawable.ic_buffalo,
        "от 345 р"
    ),
    Pizza5(
        "Нежный лосось",
        "Лосось, томаты, оливки,соус песто,помидорки черри",
        R.drawable.ic_buffalo,
        "от 345 р"
    ),
    Pizza6(
        "Нежный лосось",
        "Лосось, томаты, оливки,соус песто,помидорки черри",
        R.drawable.ic_buffalo,
        "от 345 р"
    ),
    Pizza7(
        "Нежный лосось",
        "Лосось, томаты, оливки,соус песто,помидорки черри",
        R.drawable.ic_buffalo,
        "от 345 р"
    )
}

fun getAllFoodElements(): List<FoodElement> {
    return listOf(
        FoodElement.Pizza1,
        FoodElement.Pizza2,
        FoodElement.Pizza3,
        FoodElement.Pizza4,
        FoodElement.Pizza5,
        FoodElement.Pizza6,
        FoodElement.Pizza7
    )
}

fun getFoodElement(
    title: String,
    body: String,
    image: Int,
    price: String
    ): FoodElement? {
    val map = FoodElement.values().associateBy(FoodElement::title)
    return map[title]
}