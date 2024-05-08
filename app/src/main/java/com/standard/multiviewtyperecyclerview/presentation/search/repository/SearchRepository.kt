package com.standard.multiviewtyperecyclerview.presentation.search.repository

import com.standard.multiviewtyperecyclerview.presentation.main.model.BlueCardModel
import com.standard.multiviewtyperecyclerview.presentation.search.model.AddressListEntity

interface SearchRepository {
    fun getCardList() : List<BlueCardModel>
    suspend fun getAddressList(userName : String) : AddressListEntity
}