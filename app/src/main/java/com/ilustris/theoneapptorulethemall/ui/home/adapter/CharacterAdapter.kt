package com.ilustris.theoneapptorulethemall.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ilustris.theoneapptorulethemall.R
import com.ilustris.theoneapptorulethemall.api.response.CharacterDataResponse
import com.ilustris.theoneapptorulethemall.databinding.CharacterItemLayoutBinding

class CharacterAdapter(
    private val characters: List<CharacterDataResponse>
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(character: CharacterDataResponse) {
            CharacterItemLayoutBinding.bind(itemView).apply {
                characterName.text = character.name
                val context = itemView.context
                if (character.race == "Werewolves") {
                    axicon.setImageResource(R.drawable.werewolf_5_svgrepo_com)
                    }
                    if (character.race == "Elves"){
                        axicon.setImageResource(R.drawable.crossbow_svgrepo_com)
                }
                if (character.race == "Dwarves") {
                    axicon.setImageResource(R.drawable.axe_svgrepo_com)
                }

                if (character.race == "Hobbit") {
                    axicon.setImageResource(R.drawable.hobbit_door_svgrepo_com)
                }
                if (character.race == "Orc" || character.race == "Uruk-hai") {
                    axicon.setImageResource(R.drawable.viking_svgrepo_com)
                }
                if (character.race == "Ent") {
                    axicon.setImageResource(R.drawable.tree_svgrepo_com)
                }
                if (character.race == "Goblin") {
                    axicon.setImageResource(R.drawable.rock_svgrepo_com)
                }
                if (character.race == "Human") {
                    val drawable =  ContextCompat.getDrawable(context, R.drawable.sword_origami_paper_svgrepo_com)
                    axicon.setImageDrawable(drawable)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.character_item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }



}
