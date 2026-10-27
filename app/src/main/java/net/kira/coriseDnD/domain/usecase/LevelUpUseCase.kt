package net.kira.coriseDnD.domain.usecase

import net.kira.coriseDnD.domain.repository.CharacterRepository

class LevelUpUseCase(
    private val characterRepository: CharacterRepository,
    private val statCalculator: StatCalculatorUseCase
) {
    suspend fun levelUp(characterId: Long) {
        val character = characterRepository.getById(characterId) ?: return
        val leveledUp = character.copy(level = character.level + 1)

        val newMaxHp = statCalculator.calculateMaxHp(leveledUp)
        val newMaxMl = statCalculator.calculateMaxMl(leveledUp)

        val updated = leveledUp.copy(
            hpCur = minOf(character.hpCur, newMaxHp),
            mlCur = minOf(character.mlCur, newMaxMl)
        )
        characterRepository.save(updated)
    }
}