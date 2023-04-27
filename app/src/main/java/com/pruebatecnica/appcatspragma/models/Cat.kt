package com.pruebatecnica.appcatspragma.models

import com.google.gson.annotations.SerializedName

data class Cat (
    @SerializedName("name")
    val breedName : String
)