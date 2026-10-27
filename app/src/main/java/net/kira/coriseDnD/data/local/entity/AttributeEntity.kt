package net.kira.coriseDnD.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import net.kira.coriseDnD.domain.model.Attribute
import net.kira.coriseDnD.domain.model.Character

@Entity("attribute")
data class AttributeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val code: String,
    val name: String
) {
    fun toDomain() = Attribute(id, code, name)

    companion object {
        fun fromDomain(attribute: Attribute) = AttributeEntity(
            attribute.id, attribute.code, attribute.name)
    }
}