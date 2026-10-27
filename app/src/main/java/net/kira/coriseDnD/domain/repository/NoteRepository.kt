package net.kira.coriseDnD.domain.repository

import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getByCharacter(characterId: Long): Flow<List<String>>
    suspend fun add(characterId: Long, text: String)
}