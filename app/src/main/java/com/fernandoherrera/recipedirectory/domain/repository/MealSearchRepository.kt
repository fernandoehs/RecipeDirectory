package com.fernandoherrera.recipedirectory.domain.repository

import com.fernandoherrera.recipedirectory.data.model.MealsDTO

interface MealSearchRepository {

    suspend fun getMealList(s: String): MealsDTO
}