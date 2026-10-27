package net.kira.coriseDnD.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import net.kira.coriseDnD.domain.model.Race

enum class RaceStatus {
    RECOGNIZED,
    NONRECOGNIZED
}

@Entity(tableName = "races")
data class RaceEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val inName: String,
    val outName: String,
    val shortDesc: String,
    val appearance: String,
    val relationships: String,
    val lore: String,
    val status: RaceStatus,
    val archetype: String,
    val lifespan: Int,
    val isCustom: Boolean
) {
    fun toDomain() = Race(id, outName, inName, shortDesc, appearance, relationships,
        lore, status, archetype, lifespan, isCustom)

    companion object {
        fun fromDomain(race: Race) = RaceEntity(
            race.id,
            race.inName,
            race.outName,
            race.shortDesc,
            race.appearance,
            race.relationships,
            race.lore,
            race.status,
            race.archetype,
            race.lifespan,
            race.isCustom
        )
    }
}