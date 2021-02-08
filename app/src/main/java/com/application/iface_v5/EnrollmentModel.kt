package com.application.iface_v5

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EnrollmentModel(
    val template: ByteArray?,
    val imageUri: Uri?,
    val errorCode: String,
    val errorMessage: String
) : Parcelable {

}
