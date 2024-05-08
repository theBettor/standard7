package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.standard.multiviewtyperecyclerview.databinding.ActivityAddressBinding

class AddressActivity : AppCompatActivity() {
    /*
//    * TODO
//    *  1.create XML  o
         2.viewBinding Setting  o
         3. RecyclerView  Setting
    * */
    private val binding: ActivityAddressBinding by lazy {
        ActivityAddressBinding.inflate(layoutInflater)
    }

    private val addressViewModel by viewModels<AddressViewModel> {
        AddressViewModelFactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addressViewModel.getAddressList()

        addressViewModel.getAddressList.observe(this@AddressActivity){ addressList ->
            Log.d("debug100", addressList.toString())
            //TODO 1. check observe data 2. RecyclerView Setting
        }
    }
}