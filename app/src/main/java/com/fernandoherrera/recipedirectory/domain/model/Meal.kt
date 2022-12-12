package com.fernandoherrera.recipedirectory.domain.model

data class Meal (
    val mealId: String,
    val name: String,
    val image: String,
    val category: String,
    val instructions: String,
    val latitude: String,
    val longitude: String,

    val ingredient1: String,
    val ingredient2: String,
    val ingredient3: String,
    val ingredient4: String,
    val ingredient5: String,
    val ingredient6: String,
    val ingredient7: String,
    val ingredient8: String,
    val ingredient9: String,
    val ingredient10: String,

    val measure1: String,
    val measure2: String,
    val measure3: String,
    val measure4: String,
    val measure5: String,
    val measure6: String,
    val measure7: String,
    val measure8: String,
    val measure9: String,
    val measure10: String,

) {
}