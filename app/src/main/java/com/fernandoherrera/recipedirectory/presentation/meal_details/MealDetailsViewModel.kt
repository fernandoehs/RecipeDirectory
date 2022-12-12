package com.fernandoherrera.recipedirectory.presentation.meal_details

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fernandoherrera.recipedirectory.R


class MealDetailsViewModel :  ViewModel() {

    fun urlToImage(view: ImageView, str: String?) {

        str?.let {
            val options = RequestOptions
                .placeholderOf(R.drawable.loading)
                .error(R.drawable.error)

            Glide.with(view)
                .setDefaultRequestOptions(options)
                .load(it)
                .into(view)
        }
    }
}