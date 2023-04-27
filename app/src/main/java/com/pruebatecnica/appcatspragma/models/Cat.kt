package com.pruebatecnica.appcatspragma.models

import com.google.gson.annotations.SerializedName

data class Cat (
    @SerializedName("name")
    val breedName: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("affection_level")
    val affectionLevel: Int,
    @SerializedName("intelligence")
    val intelligence: String,
    @SerializedName("reference_image_id")
    val imageUrl: String
)