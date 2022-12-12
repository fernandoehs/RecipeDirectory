package com.fernandoherrera.recipedirectory.hilt

import com.fernandoherrera.recipedirectory.common.Constants
import com.fernandoherrera.recipedirectory.data.remote.MealSearchAPI
import com.fernandoherrera.recipedirectory.data.repository.MealSearchRepositoryImpl
import com.fernandoherrera.recipedirectory.domain.repository.MealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModules {

    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealSearchAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealSearchAPI::class.java)
    }

    @Provides
    fun provideMealSearchRepository(mealSearchAPI: MealSearchAPI): MealSearchRepository {
        return MealSearchRepositoryImpl(mealSearchAPI)
    }

}