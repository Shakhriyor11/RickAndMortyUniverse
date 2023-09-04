package com.example.rickandmortyuniverse.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.rickandmortyuniverse.R
import com.example.rickandmortyuniverse.databinding.ItemCharacterBinding
import com.example.rickandmortyuniverse.presentation.model.CharacterUI
import javax.inject.Inject

class CharacterRVAdapter @Inject constructor(
    private val context: Context
) : PagingDataAdapter<CharacterUI, CharacterRVAdapter.CharacterViewHolder>(CharacterComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
         CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding
    ) : ViewHolder(binding.root) {

        fun bind(character: CharacterUI) = with(binding) {
            ivCharacter.load(character.image) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
            }
            tvNameCharacter.text = character.name
            tvOrigin.text = character.getCharacterFrom()
            statusIndicator.setBackgroundColor(character.getStatusColor())
            tvStatusCharacter.text = character.getCharacterStatus(context = context)
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<CharacterUI>() {
        override fun areItemsTheSame(oldItem: CharacterUI, newItem: CharacterUI): Boolean =
             oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: CharacterUI, newItem: CharacterUI): Boolean =
             oldItem == newItem

    }
}
