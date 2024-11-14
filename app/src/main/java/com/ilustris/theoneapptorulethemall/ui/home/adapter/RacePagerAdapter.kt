package com.ilustris.theoneapptorulethemall.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilustris.theoneapptorulethemall.R
import com.ilustris.theoneapptorulethemall.databinding.RacePagerLayoutBinding
import com.ilustris.theoneapptorulethemall.ui.home.CharactersGroup

class RacePagerAdapter (val charactersGroup: List<CharactersGroup>):RecyclerView.Adapter<RacePagerAdapter.RaceViewHolder>() {
    inner class RaceViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(charactersGroup: CharactersGroup){
            RacePagerLayoutBinding.bind(itemView).apply{
                charactersGroup.race?.let {
                    raceimage.setImageResource(it.image)

                }
            }
}}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceViewHolder {
        return RaceViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.race_pager_layout, parent, false))
    }

    override fun getItemCount(): Int {
       return charactersGroup.size
    }

    override fun onBindViewHolder(holder: RaceViewHolder, position: Int) {
        holder.bind(charactersGroup[position])
    }
}