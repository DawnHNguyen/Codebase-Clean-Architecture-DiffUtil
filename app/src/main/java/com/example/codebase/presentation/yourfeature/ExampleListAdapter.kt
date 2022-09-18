package com.example.codebase.presentation.yourfeature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.codebase.databinding.ItemRvTestBinding

class ExampleListAdapter() : ListAdapter<OKRs, ExampleListAdapter.ExampleListViewHolder>(ExampleListDiffUtil()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ExampleListViewHolder = ExampleListViewHolder.from(parent)

    override fun onBindViewHolder(
        holder: ExampleListViewHolder,
        position: Int,
    ) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ExampleListViewHolder private constructor(private val binding: ItemRvTestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OKRs) {
            binding.okrs = item
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): ExampleListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRvTestBinding.inflate(layoutInflater, parent, false)
                return ExampleListViewHolder(binding)
            }
        }
    }

    class ExampleListDiffUtil : DiffUtil.ItemCallback<String>() {
        override fun areContentsTheSame(oldItem: OKRs, newItem: OKRs) = oldItem == newItem
        override fun areItemsTheSame(oldItem: OKRs, newItem: OKRs) =
            oldItem.okrsId == newItem.okrsId
    }
}