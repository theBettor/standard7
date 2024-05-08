package com.standard.multiviewtyperecyclerview.presentation.search.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.standard.multiviewtyperecyclerview.data.database.DataSource
import com.standard.multiviewtyperecyclerview.data.remote.repository.SearchRepositoryImpl
import com.standard.multiviewtyperecyclerview.network.RetrofitClient
import com.standard.multiviewtyperecyclerview.presentation.search.model.AddressEntity
import com.standard.multiviewtyperecyclerview.presentation.search.repository.SearchRepository
import kotlinx.coroutines.launch

class AddressViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private val _getAddressList: MutableLiveData<List<AddressEntity>> = MutableLiveData()
    val getAddressList: LiveData<List<AddressEntity>> get() = _getAddressList

    fun getAddressList() = viewModelScope.launch {
        _getAddressList.value = searchRepository.getAddressList("삼성동").address
    }
}

class AddressViewModelFactory : ViewModelProvider.Factory {
    private val repository = SearchRepositoryImpl(DataSource, RetrofitClient.searchAddress)
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {

        return AddressViewModel(
            repository
        ) as T
    }
}