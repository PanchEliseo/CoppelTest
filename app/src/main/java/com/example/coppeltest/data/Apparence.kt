package com.example.coppeltest.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Apparence(
    val gender: String?,
    val race: String?,
    val height: List<String>?,
    val weight: List<String>?,
    @Json(name = "eye-color") val eyeColor: String?,
    @Json(name = "hair-color") val hairColor: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gender)
        parcel.writeString(race)
        parcel.writeStringList(height)
        parcel.writeStringList(weight)
        parcel.writeString(eyeColor)
        parcel.writeString(hairColor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Apparence> {
        override fun createFromParcel(parcel: Parcel): Apparence {
            return Apparence(parcel)
        }

        override fun newArray(size: Int): Array<Apparence?> {
            return arrayOfNulls(size)
        }
    }
}
