package com.ilustris.theoneapptorulethemall.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.ilustris.theoneapptorulethemall.api.response.CharacterDataResponse
import com.ilustris.theoneapptorulethemall.databinding.FragmentHomeBinding
import com.ilustris.theoneapptorulethemall.ui.home.adapter.CharacterAdapter
import com.ilustris.theoneapptorulethemall.ui.home.adapter.RacePagerAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val homeViewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root





        observeViewModel()
        homeViewModel.getCharacter()
        return root
    }

    private fun observeViewModel() {
        homeViewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                is HomeViewModel.HomeState.LoadingState -> {
                    // Show loading state
                }
                is HomeViewModel.HomeState.ErrorState -> {
                    // Show error state
                }
                is HomeViewModel.HomeState.CharactersState -> {
                    setupRacePager(it.charactersGroup)
                }
            }
        }
    }
private fun setupRacePager(charactersGroup: List<CharactersGroup>) {
    (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)

    updateCharacters(  charactersGroup.first())
    setupSearchView(charactersGroup.flatMap { it.characters })
        binding.racepager.adapter = RacePagerAdapter(charactersGroup)

    //configuração o listening do viewpager para atualizar a listagem dos personagens
    binding.racepager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            updateCharacters(charactersGroup[position])


        }
    })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

private fun updateCharacters(group: CharactersGroup){
    binding.characterList.adapter = CharacterAdapter( group.characters)
    binding.characterList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    binding.cltoolbar.title = group.name
    binding.characterammount.text = group.ammount.toString()
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchView = binding.idSV





    }
    private fun setupSearchView (charactersList : List <CharacterDataResponse>){

        binding.idSV.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {


                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                val searchResult = filterCharacters(newText,charactersList)
                binding.characterList.adapter = CharacterAdapter(searchResult)

                return false
            }
        })

    }

    private fun filterCharacters(query: String?, charactersList: List<CharacterDataResponse>): List<CharacterDataResponse> {

        val filteredGroups = if (query.isNullOrEmpty()) {
            charactersList
        } else {
            charactersList.filter { it.name.contains(query) }
        }
        return filteredGroups


    }


}
