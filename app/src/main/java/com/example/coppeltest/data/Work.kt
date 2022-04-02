package com.example.coppeltest.data

import android.os.Parcel
import android.os.Parcelable

data class Work(val occupation: String?, val base: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(occupation)
        parcel.writeString(base)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Work> {
        override fun createFromParcel(parcel: Parcel): Work {
            return Work(parcel)
        }

        override fun newArray(size: Int): Array<Work?> {
            return arrayOfNulls(size)
        }
    }

}
