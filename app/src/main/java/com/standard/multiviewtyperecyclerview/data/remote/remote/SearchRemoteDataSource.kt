package com.standard.multiviewtyperecyclerview.data.remote.remote

import com.standard.multiviewtyperecyclerview.data.remote.model.AddressListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRemoteDataSource {
    @GET("/search/address") // base url 앞에 있는거
    suspend fun getAddress(
        @Query("address_name") addressName: String,
        @Query("h_code") hCode: Int = 1
    ) : AddressListResponse
}