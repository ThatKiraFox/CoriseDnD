package net.kira.coriseDnD.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import net.kira.coriseDnD.domain.repository.CharacterRepository
import net.kira.coriseDnD.domain.model.Character

class CharacterListViewModel(
    characterRepository: CharacterRepository
) : ViewModel() {
    val characters: StateFlow<List<Character>> =
        characterRepository.getAll()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),
                emptyList())
}