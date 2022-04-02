package com.example.coppeltest.data

import android.os.Parcel
import android.os.Parcelable

data class Powerstates(
    val intelligence: String?,
    val strength: String?,
    val speed: String?,
    val durability: String?,
    val power: String?,
    val combat: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(intelligence)
        parcel.writeString(strength)
        parcel.writeString(speed)
        parcel.writeString(durability)
        parcel.writeString(power)
        parcel.writeString(combat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Powerstates> {
        override fun createFromParcel(parcel: Parcel): Powerstates {
            return Powerstates(parcel)
        }

        override fun newArray(size: Int): Array<Powerstates?> {
            return arrayOfNulls(size)
        }
    }
}
