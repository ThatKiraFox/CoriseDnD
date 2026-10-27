package net.kira.coriseDnD.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import net.kira.coriseDnD.domain.model.AttributeType
import net.kira.coriseDnD.domain.model.Character

@Entity(
    "character",
    foreignKeys = [
        ForeignKey(entity = RaceEntity::class, parentColumns = ["id"], childColumns = ["raceId"])
    ],
    indices = [Index("raceId")]
)
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val raceId: Long,
    val level: Int = 1,
    val exp: Int = 0,
    val hpCur: Int = 0,
    val mlCur: Int = 0
) {
    fun toDomain(attributes: Map<AttributeType, Int>) = Character(id = id,
        name, raceId, level, exp, hpCur, mlCur, attributes)

    companion object {
        fun fromDomain(character:Character) = CharacterEntity(
            id = character.id,
            name = character.name,
            raceId = character.raceId,
            level = character.level,
            exp = character.exp,
            hpCur = character.hpCur,
            mlCur = character.mlCur
        )
    }
}
