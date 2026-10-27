package net.kira.coriseDnD.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import net.kira.coriseDnD.data.local.entity.AttributeEntity
import net.kira.coriseDnD.data.local.entity.RaceEntity

@Dao
interface GameDataDao {
    @Query("SELECT * FROM races")
    fun getAllRaces(): Flow<List<RaceEntity>>

    @Query("SELECT * FROM attribute")
    suspend fun getAttributes(): List<AttributeEntity>
}