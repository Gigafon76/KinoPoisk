package ru.jay.skillcinema.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.jay.skillcinema.data.entity.database.SavedCollection
import ru.jay.skillcinema.data.entity.database.SavedFilm

@Database(entities = [SavedFilm::class, SavedCollection::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun savedFilmDao(): SavedFilmDao

}