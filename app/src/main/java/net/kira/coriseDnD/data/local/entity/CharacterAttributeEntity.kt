package net.kira.coriseDnD.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "character_attributes",
    primaryKeys = ["characterId", "attributeId"],
    foreignKeys = [
        ForeignKey(
            entity = CharacterEntity::class,
            parentColumns = ["id"],
            childColumns = ["characterId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = AttributeEntity::class, parentColumns = ["id"], childColumns = ["attributeId"])
    ]
)
data class CharacterAttributeEntity(
    val characterId: Long,
    val attributeId: Long,
    val value: Int
)
