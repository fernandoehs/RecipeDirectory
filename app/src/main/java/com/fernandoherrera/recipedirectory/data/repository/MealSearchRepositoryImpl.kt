package com.fernandoherrera.recipedirectory.data.repository

import com.fernandoherrera.recipedirectory.data.model.MealsDTO
import com.fernandoherrera.recipedirectory.data.remote.MealSearchAPI
import com.fernandoherrera.recipedirectory.domain.repository.MealSearchRepository

class MealSearchRepositoryImpl(private val mealSearchAPI: MealSearchAPI): MealSearchRepository {

    override suspend fun getMealList(s: String): MealsDTO {
        return mealSearchAPI.getMealList(s)
    }
}