package com.pruebatecnica.appcatspragma.data

import com.pruebatecnica.appcatspragma.models.Cat
import retrofit2.http.GET
import retrofit2.http.Header

interface Apis {
    @GET("breeds")
    suspend fun getCats(@Header("x-apikey") apiKey: String =  ApiConstants.API_KEY) : List<Cat>
}