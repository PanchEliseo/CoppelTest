package com.example.coppeltest.data

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class Biography(
    @Json(name = "full-name") val fullName: String?,
    @Json(name = "alter-egos") val alterEgos: String?,
    val aliases: List<String>?,
    @Json(name = "place-of-birth") val placeOfBirth: String?,
    @Json(name = "first-appearance") val firstAppearance: String?,
    val publisher: String?,
    val alignment: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeString(alterEgos)
        parcel.writeStringList(aliases)
        parcel.writeString(placeOfBirth)
        parcel.writeString(firstAppearance)
        parcel.writeString(publisher)
        parcel.writeString(alignment)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Biography> {
        override fun createFromParcel(parcel: Parcel): Biography {
            return Biography(parcel)
        }

        override fun newArray(size: Int): Array<Biography?> {
            return arrayOfNulls(size)
        }
    }
}
