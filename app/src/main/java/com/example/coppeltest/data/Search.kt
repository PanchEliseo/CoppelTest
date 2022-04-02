package com.example.coppeltest.data

import com.google.gson.annotations.SerializedName

data class Search(val response: String?, @SerializedName("results-for") val resultsFor: String?, val results: List<SuperHeroForId>?)
