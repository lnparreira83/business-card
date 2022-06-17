package com.lnp.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lnp.businesscard.data.BusinessCard
import com.lnp.businesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter : ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallBack()) {
    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater,parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item:BusinessCard){
            binding.nomeView.text = item.nome
            binding.telefoneView.text = item.telefone
            binding.emailView.text = item.email
            binding.githubView.text = item.github
            binding.empresaView.text = item.empresa
            binding.cdContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.cdContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<BusinessCard>(){
        override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

        override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
            oldItem.id == newItem.id
    }
}