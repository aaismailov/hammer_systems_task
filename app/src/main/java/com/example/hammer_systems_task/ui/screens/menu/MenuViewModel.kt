package com.example.hammer_systems_task.ui.screens.menu

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hammer_systems_task.data.FoodCategory
import com.example.hammer_systems_task.data.getFoodCategory

class MenuViewModel : ViewModel() {

    val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(FoodCategory.PizzaCategory)

    fun onSelectedChange(text: String) {
        val newCategory = getFoodCategory(text)
        selectedCategory.value = newCategory
    }
}