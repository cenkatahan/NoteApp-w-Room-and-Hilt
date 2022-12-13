package com.atahan.noteapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.atahan.noteapp.databinding.LayoutItemNoteBinding
import com.atahan.noteapp.model.NoteEntity
import javax.inject.Inject

class NoteAdapter @Inject constructor() : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    private lateinit var binding: LayoutItemNoteBinding

    private val differCallback = object : DiffUtil.ItemCallback<NoteEntity>() {
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = LayoutItemNoteBinding.inflate(inflater, parent, false)
        return NoteHolder()
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bindItem(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class NoteHolder : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: NoteEntity) {


            binding.apply {
                tvItemTitle.text = item.title
                tvItemDesc.text = item.desc
            }
        }
    }
}