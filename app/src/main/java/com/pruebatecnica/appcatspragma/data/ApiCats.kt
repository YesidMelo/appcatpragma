package com.pruebatecnica.appcatspragma.data

import android.util.Log
import com.pruebatecnica.appcatspragma.models.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiCats {
    fun getListCats(): Flow<List<Cat>>
}


class ApiCatsImpl : ApiCats {
    private val retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apis = retrofit.create(Apis::class.java)

    override fun getListCats(): Flow<List<Cat>> = flow {
        try {
            val listCats = apis.getCats()
            emit(listCats)
        } catch (e: Exception) {
            throw e
        }
    }

}