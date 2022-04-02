package com.example.coppeltest.data

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class Connections(@Json(name = "group-affiliation") val groupAffiliation: String?, val relatives: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(groupAffiliation)
        parcel.writeString(relatives)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Connections> {
        override fun createFromParcel(parcel: Parcel): Connections {
            return Connections(parcel)
        }

        override fun newArray(size: Int): Array<Connections?> {
            return arrayOfNulls(size)
        }
    }

}
