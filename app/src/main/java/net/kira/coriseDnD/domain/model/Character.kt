package net.kira.coriseDnD.domain.model

data class Character(
    val id: Long,
    val name: String,
    val raceId: Long,
    val level: Int,
    val exp: Int,
    val hpCur: Int,
    val mlCur: Int,
    val attributes: Map<AttributeType, Int>
)
