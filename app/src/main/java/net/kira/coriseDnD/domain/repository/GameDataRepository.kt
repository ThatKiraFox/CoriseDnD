package net.kira.coriseDnD.domain.repository

import kotlinx.coroutines.flow.Flow
import net.kira.coriseDnD.domain.model.Attribute
import net.kira.coriseDnD.domain.model.Race

interface GameDataRepository {
    fun getAllRaces(): Flow<List<Race>>
    suspend fun getAttributes(): List<Attribute>
}