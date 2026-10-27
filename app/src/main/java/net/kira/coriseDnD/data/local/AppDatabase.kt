package net.kira.coriseDnD.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import net.kira.coriseDnD.data.local.dao.CharacterDao
import net.kira.coriseDnD.data.local.dao.GameDataDao
import net.kira.coriseDnD.data.local.dao.NotesDao
import net.kira.coriseDnD.data.local.entity.AttributeEntity
import net.kira.coriseDnD.data.local.entity.CharacterAttributeEntity
import net.kira.coriseDnD.data.local.entity.CharacterEntity
import net.kira.coriseDnD.data.local.entity.NoteEntity
import net.kira.coriseDnD.data.local.entity.RaceEntity

@Database(
    entities = [
        CharacterEntity::class, RaceEntity::class,
        AttributeEntity::class, CharacterAttributeEntity::class,
        NoteEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun gameDataDao(): GameDataDao
    abstract fun noteDao(): NotesDao
}