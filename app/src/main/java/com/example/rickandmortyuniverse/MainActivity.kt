package com.example.rickandmortyuniverse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyuniverse.databinding.ActivityMainBinding
import com.example.rickandmortyuniverse.presentation.ui.adapter.CharacterRVAdapter
import com.example.rickandmortyuniverse.presentation.ui.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]

        val characterAdapter = CharacterRVAdapter(applicationContext)

        binding.rvCharacters.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter
        }
        this.lifecycleScope.launchWhenCreated {
            viewModel.characters.collectLatest { pagingData ->
                characterAdapter.submitData(pagingData)
            }
        }
    }
}