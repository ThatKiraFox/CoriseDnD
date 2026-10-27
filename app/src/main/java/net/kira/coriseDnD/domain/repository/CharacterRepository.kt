package net.kira.coriseDnD.domain.repository

import kotlinx.coroutines.flow.Flow
import net.kira.coriseDnD.domain.model.Character

interface CharacterRepository {
    fun getAll(): Flow<List<Character>>
    suspend fun getById(id: Long): Character?
    suspend fun save(character: Character): Long
}