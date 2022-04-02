package com.example.coppeltest.data

import com.google.gson.annotations.SerializedName

data class Results(@SerializedName("id") val id: String,
                   @SerializedName("name") val name: String)