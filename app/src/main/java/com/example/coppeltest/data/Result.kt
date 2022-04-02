package com.example.coppeltest.data

import com.google.gson.annotations.SerializedName

data class Result(@SerializedName("id") val id: String,
                  @SerializedName("name") val name: String,
                  @SerializedName("powerstats") val powerstats: Powerstates,
                  @SerializedName("biography") val biography: Biography,
                  @SerializedName("appearance") val appearance: Apparence,
                  @SerializedName("work") val work: Work,
                  @SerializedName("connections") val connections: Connections,
                  @SerializedName("image") val image: Image
)
