package net.kira.coriseDnD.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import net.kira.coriseDnD.data.local.entity.NoteEntity

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes WHERE characterId = :characterId")
    fun getByCharacter(characterId: Long): Flow<List<NoteEntity>>

    @Insert
    suspend fun insert(note: NoteEntity): Long
}