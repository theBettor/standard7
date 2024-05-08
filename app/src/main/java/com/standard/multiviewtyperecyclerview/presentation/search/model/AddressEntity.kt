package com.standard.multiviewtyperecyclerview.presentation.search.model

data class AddressListEntity(val address: List<AddressEntity>)
data class AddressEntity(val addressName: String, val hCode: Int)