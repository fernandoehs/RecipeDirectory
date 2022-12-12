package com.fernandoherrera.recipedirectory.data.remote

import com.fernandoherrera.recipedirectory.data.model.MealsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MealSearchAPI {

    @GET("v1/239c8ff6-0da5-4f46-a60b-fdb789b3f6a5")
    suspend fun getMealList(@Query("s") s: String): MealsDTO
}