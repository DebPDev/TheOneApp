package com.ilustris.theoneapptorulethemall.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilustris.theoneapptorulethemall.api.TheOneService
import com.ilustris.theoneapptorulethemall.api.response.CharacterDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    sealed class HomeState{
        object LoadingState: HomeState()
        object  ErrorState: HomeState()
      data class CharactersState(val charactersGroup: List<CharactersGroup>): HomeState()
    }
    val state = MutableLiveData<HomeState>()
    val theOneService   = TheOneService()

    fun getCharacter() {

        viewModelScope.launch(Dispatchers.IO) {
//            val character = theOneService.getCharacter()
//            val movie = theOneService.getMovie()
//            val groups = character.docs.groupBy { it.race }.map {
//                val race = Race.entries.find    { r ->
//                    r.name.equals(it.key, ignoreCase = true)
//                }
//                CharactersGroup(
//                    it.key,
//                    it.value,
//                    it.value.size,
//                    race
//                )
//
//                }
//            state.postValue(HomeState.CharactersState(groups))
        }

    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}