package com.example.coppeltest.api

import com.example.coppeltest.data.*

data class ApiListResponse<T>(
    val status: String,
    val results: List<T>
)

data class ApiSingleResponse<T>(
    val response: String,
    val id: String,
    val name: String,
    val powerstats: Powerstates,
    val biography: Biography
    /*val appearance: Apparence
    val work: Work,
    val connections: Connections,
    val image: Image*/
)