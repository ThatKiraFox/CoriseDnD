package net.kira.coriseDnD.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.kira.coriseDnD.data.local.dao.GameDataDao
import net.kira.coriseDnD.domain.model.Attribute
import net.kira.coriseDnD.domain.model.Race
import net.kira.coriseDnD.domain.repository.GameDataRepository

class GameDataRepositoryImpl(private val dao: GameDataDao): GameDataRepository {
    override fun getAllRaces(): Flow<List<Race>> = dao.getAllRaces().map { list ->
    list.map { it.toDomain() } }

    override suspend fun getAttributes(): List<Attribute> =
        dao.getAttributes().map { it.toDomain() }

}

