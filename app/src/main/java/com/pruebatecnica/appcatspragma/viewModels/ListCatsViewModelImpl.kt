package com.pruebatecnica.appcatspragma.viewModels

import androidx.lifecycle.MutableLiveData
import com.pruebatecnica.appcatspragma.data.ApiCats
import com.pruebatecnica.appcatspragma.data.ApiCatsImpl
import com.pruebatecnica.appcatspragma.models.Cat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ListCatsViewModelImpl (private val apiCats: ApiCats = ApiCatsImpl()) : ListCatsViewModel() {
    private val listCatsLiveData = MutableLiveData<List<Cat>>()
    private val notifyErrorLiveData = MutableLiveData<Exception?>()

    override fun getListCatsLiveData(): MutableLiveData<List<Cat>> = listCatsLiveData

    override fun loadListCats() {
        GlobalScope.launch {
            apiCats
                .getListCats()
                .catch {
                    val exception = Exception("Surgio un error inesperado")
                    notifyErrorLiveData.postValue(exception)
                }
                .collect{
                    listCatsLiveData.postValue(it)
                }
        }
    }

    override fun notifyErrorLiveData(): MutableLiveData<Exception?> = notifyErrorLiveData
}