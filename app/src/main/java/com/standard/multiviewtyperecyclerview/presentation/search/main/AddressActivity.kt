package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.standard.multiviewtyperecyclerview.databinding.ActivityAddressBinding
import com.standard.multiviewtyperecyclerview.presentation.main.detail.DetailActivity
import com.standard.multiviewtyperecyclerview.presentation.main.model.BlueCardModel
import com.standard.multiviewtyperecyclerview.presentation.search.model.AddressEntity
import com.standard.multiviewtyperecyclerview.presentation.search.model.AddressListEntity
import com.standard.multiviewtyperecyclerview.presentation.search.model.AddressModel

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
    private val addressAdapter : AddressAdapter by lazy {
        AddressAdapter { address ->
            adapterOnClick(address)
        }
    }
    private lateinit var addressList : List<AddressModel>

    private val addressViewModel by viewModels<AddressViewModel> {
        AddressViewModelFactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        addressViewModel.getAddressList.observe(this@AddressActivity){ addressList ->
            Log.d("debug100", addressList.toString())
//            TODO 1. check observe data 2. RecyclerView Setting
            initViewModel()
            initData()
        }
    }
    private fun initData() {
        addressViewModel.getAddressList() // Model이 아닌 List가 들어간다... 왜?
    }

    private fun initView() {
        addressAdapter.addressList = addressList
        with(binding.rvAddress) {
            adapter = addressAdapter
            layoutManager = LinearLayoutManager(this@AddressActivity)
        }

    }

    private fun initViewModel() {
//        addressViewModel.getAddressList.observe(this@AddressActivity) {
//            addressList = it
//
//            initView()
//        }
        addressViewModel.getAddressList.observe(this@AddressActivity) { addressEntities ->
            addressList = addressEntities.map { entity ->
                AddressModel(
                    addressName = "삼성동"
                )
            }
            initView()
        }
    }

    private fun adapterOnClick(card : AddressModel) {
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle().apply {
            putParcelable(DetailActivity.EXTRA_CARD, card)
        }
        intent.putExtras(bundle)
        startActivity(intent)
    }
}