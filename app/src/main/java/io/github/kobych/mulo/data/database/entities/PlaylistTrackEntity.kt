package io.github.kobych.mulo.data.database.entities

import androidx.room3.Entity

@Entity(
    tableName = "playlist_tracks",
    primaryKeys = ["playlistId", "trackId"],
)
data class PlaylistTrackEntity(
    val playlistId: Int,
    val trackId: Int,
    val position: Int,
)
