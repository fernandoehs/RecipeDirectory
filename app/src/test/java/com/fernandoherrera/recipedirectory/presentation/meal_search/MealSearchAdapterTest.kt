package com.fernandoherrera.recipedirectory.presentation.meal_search

import org.junit.Assert.*

import org.junit.Test

class MealSearchAdapterTest {
    val assertions = MealSearchAdapter()

    @Test
    fun getItemCount() {
        assertNotEquals(25,assertions.itemCount)
    }



}