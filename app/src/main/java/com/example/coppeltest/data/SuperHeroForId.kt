package com.example.coppeltest.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class SuperHeroForId(
    @SerializedName("response") val response: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("powerstats") val powerstats: Powerstates?,
    @SerializedName("biography") val biography: Biography?,
    @SerializedName("appearance") val appearance: Apparence?,
    @SerializedName("work") val work: Work?,
    @SerializedName("connections") val connections: Connections?,
    @SerializedName("image") val image: Image?,
): Parcelable {
    var expanded: Boolean = false

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Powerstates::class.java.classLoader),
        parcel.readParcelable(Biography::class.java.classLoader),
        parcel.readParcelable(Apparence::class.java.classLoader),
        parcel.readParcelable(Work::class.java.classLoader),
        parcel.readParcelable(Connections::class.java.classLoader),
        parcel.readParcelable(Image::class.java.classLoader)
    ) {
        expanded = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(response)
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeParcelable(powerstats, flags)
        parcel.writeParcelable(biography, flags)
        parcel.writeParcelable(appearance, flags)
        parcel.writeParcelable(work, flags)
        parcel.writeParcelable(connections, flags)
        parcel.writeParcelable(image, flags)
        parcel.writeByte(if (expanded) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SuperHeroForId> {
        override fun createFromParcel(parcel: Parcel): SuperHeroForId {
            return SuperHeroForId(parcel)
        }

        override fun newArray(size: Int): Array<SuperHeroForId?> {
            return arrayOfNulls(size)
        }
    }
}