package com.standard.multiviewtyperecyclerview.presentation.search.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.standard.multiviewtyperecyclerview.databinding.ItemAddressBinding
import com.standard.multiviewtyperecyclerview.presentation.search.model.AddressModel

class AddressAdapter(private val onClick: (AddressModel) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var addressList = listOf<AddressModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemAddressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return addressList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class Holder(private val binding: ItemAddressBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(address: AddressModel) {
            binding.tvAddressName.text = address.addressName
        }
    }
}