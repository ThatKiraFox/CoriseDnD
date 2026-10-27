package net.kira.coriseDnD.domain.usecase

import net.kira.coriseDnD.domain.model.AttributeType
import net.kira.coriseDnD.domain.repository.CharacterRepository
import net.kira.coriseDnD.domain.model.Character

class CharacterBuilderUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend fun createCharacter(name: String, raceId: Long, attributes: Map<AttributeType, Int>): Long {
        val character = Character(
            id = 0, name = name, raceId = raceId,
            level = 1, exp = 0, hpCur = 0, mlCur = 0,
            attributes = attributes
        )
        return characterRepository.save(character)
    }
}