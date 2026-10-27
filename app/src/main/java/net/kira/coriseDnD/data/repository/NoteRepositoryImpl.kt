package net.kira.coriseDnD.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.kira.coriseDnD.data.local.dao.NotesDao
import net.kira.coriseDnD.data.local.entity.NoteEntity
import net.kira.coriseDnD.domain.repository.NoteRepository

class NoteRepositoryImpl(private val dao: NotesDao): NoteRepository {
    override fun getByCharacter(characterId: Long): Flow<List<String>> =
        dao.getByCharacter(characterId).map { list -> list.map { it.text } }


    override suspend fun add(characterId: Long, text: String) {
        dao.insert(NoteEntity(characterId = characterId, text = text))
    }
}