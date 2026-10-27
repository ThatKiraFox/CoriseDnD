package net.kira.coriseDnD.domain.usecase

import net.kira.coriseDnD.domain.model.AttributeType
import net.kira.coriseDnD.domain.model.Character

class StatCalculatorUseCase {

    companion object {
        private const val BASE_HP = 10
        private const val ENDURANCE_TIER_THRESHOLD = 5
        private const val HP_PER_LEVEL = 2
        private const val ML_BASE_OFFSET = 5
        private const val ML_MULTIPLIER = 10
    }

    fun calculateMaxHp(character: Character): Int {
        val endurance = character.attributes[AttributeType.ENDURANCE]?:0
        val bonusFromEndurance = if (endurance <= ENDURANCE_TIER_THRESHOLD) {
            endurance
        } else {
            ENDURANCE_TIER_THRESHOLD + (endurance - ENDURANCE_TIER_THRESHOLD) * HP_PER_LEVEL
        }
        return BASE_HP + bonusFromEndurance + character.level * HP_PER_LEVEL
    }
    fun calculateMaxMl(character: Character): Int =
        (character.level + (character.attributes[AttributeType.WILL]?:0) + ML_BASE_OFFSET) * ML_MULTIPLIER
}