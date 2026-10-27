package net.kira.coriseDnD.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import net.kira.coriseDnD.data.local.entity.CharacterAttributeEntity
import net.kira.coriseDnD.data.local.entity.CharacterEntity

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character")
    fun getAll(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM character WHERE id = :id")
    suspend fun getById(id: Long): CharacterEntity?

    @Insert
    suspend fun insert(character: CharacterEntity): Long

    @Update
    suspend fun update(character: CharacterEntity)

    @Query("SELECT * FROM character_attributes WHERE characterId = :characterId")
    suspend fun getAttributes(characterId: Long): List<CharacterAttributeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAttribute(attribute: CharacterAttributeEntity)
}