package com.example.coppeltest.repository

import com.example.coppeltest.api.Api
import com.example.coppeltest.data.Search
import com.example.coppeltest.data.SuperHeroForId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object SuperHeroRepository {

    suspend fun getSuperHero(id: String): Response<SuperHeroForId> {
        return withContext(Dispatchers.IO) {
            Api.service.getSuperHero(id)
        }
    }

    suspend fun getSuperHeroForSearch(name: String): Response<Search> {
        return withContext(Dispatchers.IO) {
            Api.service.getSuperHeroForSearch(name)
        }
    }

}