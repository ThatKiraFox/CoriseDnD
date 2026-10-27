package net.kira.coriseDnD.domain.model

import net.kira.coriseDnD.data.local.entity.RaceStatus

data class Race(
    val id: Long,
    val outName: String,
    val inName: String,
    val shortDesc: String,
    val appearance: String,
    val relationships: String,
    val lore: String,
    val status: RaceStatus,
    val archetype: String,
    val lifespan: Int,
    val isCustom: Boolean
)
