package com.fernandoherrera.recipedirectory.presentation.meal_search

import org.junit.Assert.*

import org.junit.Test

class MealSearchFragmentTest {
    val assertions = MealSearchFragment()

    @Test
    fun onQueryTextSubmit() {
        val string1 = "Sushi"
        val string2 = "Timbits"
        assertFalse(assertions.onQueryTextSubmit(string1))
        assertFalse(assertions.onQueryTextSubmit(string2))
    }

    @Test
    fun onQueryTextChange() {
        val stringNull = ""
        assertFalse(assertions.onQueryTextSubmit(stringNull))
    }
}