package com.pruebatecnica.appcatspragma.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pruebatecnica.appcatspragma.models.Cat

abstract class ListCatsViewModel : ViewModel() {
    abstract fun getListCatsLiveData(): MutableLiveData<List<Cat>>
    abstract fun loadListCats()
    abstract fun notifyErrorLiveData(): MutableLiveData<Exception?>
}
