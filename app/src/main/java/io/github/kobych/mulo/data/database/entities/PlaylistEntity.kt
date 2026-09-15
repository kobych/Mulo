package io.github.kobych.mulo.data.database.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
data class PlaylistEntity(
    @PrimaryKey val id: Int,
    val name: String,
)
