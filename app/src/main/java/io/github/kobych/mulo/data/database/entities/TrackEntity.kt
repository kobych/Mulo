package io.github.kobych.mulo.data.database.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
data class TrackEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val artist: String,
    val album: String,
    val duration: Long,
    val uri: String,
    val hash: String
)
