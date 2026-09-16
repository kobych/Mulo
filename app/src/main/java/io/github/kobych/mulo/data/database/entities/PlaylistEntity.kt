package io.github.kobych.mulo.data.database.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "playlists")
data class PlaylistEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
)
