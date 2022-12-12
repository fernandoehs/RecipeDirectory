package com.fernandoherrera.recipedirectory.presentation.meal_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.fernandoherrera.recipedirectory.databinding.FragmentMealDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailsFragment : Fragment() {

    private var _binding: FragmentMealDetailsBinding? = null
    val binding: FragmentMealDetailsBinding
        get() = _binding!!

    private val mealSearchViewModel: MealDetailsViewModel by viewModels()
    private val args: MealDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealDetailsBinding.inflate(inflater, container, false)

        Parameters()
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.detailsBackArrow.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.button.setOnClickListener{
            val DetailsToMap = MealDetailsFragmentDirections.actionMealDetailsFragmentToMapsFragment()
            DetailsToMap.setLatitude(args.latitud)
            DetailsToMap.setLongitude(args.longitud)
            DetailsToMap.setName(args.name)
            findNavController().navigate(DetailsToMap)
        }

        mealSearchViewModel.urlToImage(binding.imageDish,args.image)
    }

    private fun Parameters() {
        binding.nameDish.text = args.name
        binding.instructions.text = args.instructions
        binding.ingredient1.text = args.ingredient1
        binding.measure1.text = args.measure1
        binding.ingredient2.text = args.ingredient2
        binding.measure2.text = args.measure2
        binding.ingredient3.text = args.ingredient3
        binding.measure3.text = args.measure3
        binding.ingredient4.text = args.ingredient4
        binding.measure4.text = args.measure4
        binding.ingredient5.text = args.ingredient5
        binding.measure5.text = args.measure5
    }
}