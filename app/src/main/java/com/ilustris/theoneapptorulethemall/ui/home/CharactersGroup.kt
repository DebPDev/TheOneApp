package com.ilustris.theoneapptorulethemall.ui.home

import com.ilustris.theoneapptorulethemall.R
import com.ilustris.theoneapptorulethemall.api.response.CharacterDataResponse

data class CharactersGroup( val name: String?, val characters: List<CharacterDataResponse>, val ammount: Int, val race: Race? )

enum class Race(val icon: Int = R.drawable.treeoflive, val image: Int = R.drawable.treeoflive,) {

    HOBBIT(R.drawable.hobbit_door_svgrepo_com,R.drawable.hobbit_door_svgrepo_com),
    ELF(R.drawable.crossbow_svgrepo_com,R.drawable.elf),
    DWARF(R.drawable.axe_svgrepo_com,R.drawable.axe_svgrepo_com),
    HUMAN(R.drawable.sword_origami_paper_svgrepo_com,R.drawable.sword_origami_paper_svgrepo_com),
}