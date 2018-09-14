package com.example.admin.week7final.helper.adapter

import android.arch.lifecycle.MutableLiveData
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.admin.week7final.R
import com.example.admin.week7final.databinding.ItemNumberBinding

class NumbersRecyclerAdapter(val data: MutableLiveData<List<Int>>,
                             val current_clicked: MutableLiveData<Int>) : RecyclerView.Adapter<NumbersRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemNumberBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_number, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = data.value?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data.value?.let {
            holder.binding.tvNumber.text = it[position].toString()
        }
    }

    inner class ViewHolder(val binding: ItemNumberBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                data.value?.let {
                    current_clicked.value = it[adapterPosition]
                }
            }
        }
    }
}
