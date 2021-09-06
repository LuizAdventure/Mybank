package com.luizalberto.transf.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.luizalberto.transf.data.Transf
import com.luizalberto.transf.databinding.ItemtransferenciaBinding


class TransferenciaAdapter :
        ListAdapter<Transf, TransferenciaAdapter.ViewHolder>(DiffCallback()){

    var listenerShare:(View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemtransferenciaBinding.inflate(inflater, parent, false)

        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }



    inner class ViewHolder(
            private val binding: ItemtransferenciaBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Transf){
            binding.tvPara.text = item.para
            binding.tvValor.text = item.valor

            binding.cdContent.setOnClickListener{
                listenerShare(it)
            }
        }
    }



}

class DiffCallback: DiffUtil.ItemCallback<Transf>(){
    override fun areItemsTheSame(oldItem: Transf, newItem: Transf) = oldItem ==newItem
        override fun areContentsTheSame(oldItem: Transf, newItem: Transf)
        = oldItem.id == newItem.id
    }



