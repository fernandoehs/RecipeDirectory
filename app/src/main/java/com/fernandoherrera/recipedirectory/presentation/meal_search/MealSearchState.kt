package com.fernandoherrera.recipedirectory.presentation.meal_search

import com.fernandoherrera.recipedirectory.domain.model.Meal

data class MealSearchState(
    val data: List<Meal>? = null,
    val error: String = "",
    val isLoading: Boolean = false
) {
}