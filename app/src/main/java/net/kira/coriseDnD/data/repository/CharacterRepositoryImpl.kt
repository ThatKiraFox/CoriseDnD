package net.kira.coriseDnD.data.repository

import androidx.collection.emptyScatterMap
import androidx.compose.ui.util.fastMap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.kira.coriseDnD.data.local.dao.CharacterDao
import net.kira.coriseDnD.data.local.entity.CharacterAttributeEntity
import net.kira.coriseDnD.data.local.entity.CharacterEntity
import net.kira.coriseDnD.domain.model.AttributeCatalog
import net.kira.coriseDnD.domain.repository.CharacterRepository
import net.kira.coriseDnD.domain.model.Character

class CharacterRepositoryImpl(
    private val dao: CharacterDao,
    private val attributeCatalog: AttributeCatalog
): CharacterRepository {

    override fun getAll(): Flow<List<Character>> =
        dao.getAll().map { list -> list.fastMap { it.toDomain(mapOf())} }


    override suspend fun getById(id: Long): Character? {
        val entity = dao.getById(id) ?: return null
        val attributes = dao.getAttributes(id).associate { row ->
            attributeCatalog.typeOf(row.attributeId) to row.value }
        return entity.toDomain(attributes)
    }

    override suspend fun save(character: Character): Long {
        val id = dao.insert(CharacterEntity.fromDomain(character))
        character.attributes.forEach { (attributeType, value) ->
            dao.upsertAttribute(CharacterAttributeEntity(
                id, attributeCatalog.idOf(attributeType), value))
        }
        return id
    }

}