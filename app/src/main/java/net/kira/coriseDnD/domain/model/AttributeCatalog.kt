package net.kira.coriseDnD.domain.model

import net.kira.coriseDnD.domain.repository.GameDataRepository

class AttributeCatalog(private val gameDataRepository: GameDataRepository) {
    private var idByType: Map<AttributeType, Long> = emptyMap()

    suspend fun ensureLoaded() {
        if (idByType.isNotEmpty()) return
        val attrs = gameDataRepository.getAttributes()
        idByType = attrs.associate { attr ->
            AttributeType.entries.first { it.code == attr.code } to attr.id
        }
    }

    fun idOf(type: AttributeType): Long =
        idByType[type] ?: error("AttributeCatalog not loaded, try running \'ensureLoaded()\'")
    fun typeOf(id: Long): AttributeType =
        idByType.entries.first { it.value == id }.key
}