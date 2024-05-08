package com.standard.multiviewtyperecyclerview.presentation.search.mapper

import com.standard.multiviewtyperecyclerview.data.remote.model.AddressListResponse
import com.standard.multiviewtyperecyclerview.data.remote.model.AddressResponse
import com.standard.multiviewtyperecyclerview.presentation.search.model.AddressEntity
import com.standard.multiviewtyperecyclerview.presentation.search.model.AddressListEntity

fun AddressListResponse.toEntity() = AddressListEntity(
    address = address.asAddressEntity()
)

fun List<AddressResponse>.asAddressEntity(): List<AddressEntity> {
    return map {
        AddressEntity(
            it.addressName,
            it.hCode
        )
    }
}