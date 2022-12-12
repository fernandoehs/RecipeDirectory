package com.fernandoherrera.recipedirectory.presentation.meal_search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.fernandoherrera.recipedirectory.databinding.FragmentMealSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MealSearchFragment : Fragment(), SearchView.OnQueryTextListener {

    private var _binding: FragmentMealSearchBinding? = null
    val binding: FragmentMealSearchBinding
        get() = _binding!!

    private val mealSearchViewModel: MealSearchViewModel by viewModels()

    private val mealSearchAdapter = MealSearchAdapter()

    private lateinit var svSearch : SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealSearchBinding.inflate(inflater, container, false)

        svSearch = binding.search
        initListener()
        return _binding?.root

    }

    private fun initListener() {
        svSearch.setOnQueryTextListener(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initListener()

        binding.searchRecycler.apply {
            adapter = mealSearchAdapter
        }

        lifecycle.coroutineScope.launchWhenCreated {
            mealSearchViewModel.mealSearchList.collectLatest {
                if (it.isLoading) {
                    binding.noRecipeFound.visibility = View.GONE
                    binding.progresMealSearch.visibility = View.VISIBLE
                }

                if (it.error.isNotBlank()) {
                    binding.noRecipeFound.visibility = View.GONE
                    binding.progresMealSearch.visibility = View.GONE
                }

                it.data?.let {
                    if (it.isEmpty()) {
                        binding.noRecipeFound.visibility = View.VISIBLE
                    }

                    binding.progresMealSearch.visibility = View.GONE
                    mealSearchAdapter.setContentList(it.toMutableList())
                }
            }
        }
        ParametersToDetails()
        mealSearchViewModel.searchMealList("")
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            mealSearchAdapter.filter(newText.lowercase())
        }
        return false
    }

    private fun ParametersToDetails() {
        mealSearchAdapter.itemClickListener {
            val mealSearchToDetailsAction =
                MealSearchFragmentDirections.actionMealSearchFragmentToMealDetailsFragment()
            mealSearchToDetailsAction.setMealId(it.mealId)
            mealSearchToDetailsAction.setName(it.name)
            mealSearchToDetailsAction.setImage(it.image)
            mealSearchToDetailsAction.setInstructions(it.instructions)
            mealSearchToDetailsAction.setIngredient1(it.ingredient1)
            mealSearchToDetailsAction.setMeasure1(it.measure1)
            mealSearchToDetailsAction.setIngredient2(it.ingredient2)
            mealSearchToDetailsAction.setMeasure2(it.measure2)
            mealSearchToDetailsAction.setIngredient3(it.ingredient3)
            mealSearchToDetailsAction.setMeasure3(it.measure3)
            mealSearchToDetailsAction.setIngredient4(it.ingredient4)
            mealSearchToDetailsAction.setMeasure4(it.measure4)
            mealSearchToDetailsAction.setIngredient5(it.ingredient5)
            mealSearchToDetailsAction.setMeasure5(it.measure5)
            mealSearchToDetailsAction.setLongitud(it.longitude)
            mealSearchToDetailsAction.setLatitud(it.latitude)
            findNavController().navigate(mealSearchToDetailsAction)

        }
    }


}