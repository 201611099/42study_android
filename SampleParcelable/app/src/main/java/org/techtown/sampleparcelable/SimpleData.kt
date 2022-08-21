package org.techtown.sampleparcelable

import android.os.Parcel
import android.os.Parcelable

class SimpleData(var number: Int, var msg: String): Parcelable {
    constructor(parcel: Parcel): this() {
        parcel.run {
            number = readInt()
            msg = readString()
        }
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }
}