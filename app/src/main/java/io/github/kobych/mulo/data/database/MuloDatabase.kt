package io.github.kobych.mulo.data.database

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import io.github.kobych.mulo.data.database.entities.PlaylistEntity
import io.github.kobych.mulo.data.database.entities.PlaylistTrackEntity
import io.github.kobych.mulo.data.database.entities.TrackEntity

@Database(
    entities = [PlaylistEntity::class, PlaylistTrackEntity::class, TrackEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MuloDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var instance: MuloDatabase? = null

        fun getDatabase(context: Context): MuloDatabase =
            instance ?: synchronized(this) {
                Room
                    .databaseBuilder(context, MuloDatabase::class.java, "mulo_database")
                    .fallbackToDestructiveMigration(false)
                    .build()
                    .also {
                        instance = it
                    }
            }
    }
}