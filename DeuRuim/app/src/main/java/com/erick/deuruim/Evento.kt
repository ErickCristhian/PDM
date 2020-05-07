package com.erick.deuruim

import android.os.Parcel
import android.os.Parcelable

class Evento (var descricao: String, var nota: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun toString(): String {
        return "${descricao} - ${nota}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(descricao)
        parcel.writeInt(nota)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Evento> {
        override fun createFromParcel(parcel: Parcel): Evento {
            return Evento(parcel)
        }

        override fun newArray(size: Int): Array<Evento?> {
            return arrayOfNulls(size)
        }
    }
}