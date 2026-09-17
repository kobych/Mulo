package io.github.kobych.mulo.data.mapper

import io.github.kobych.mulo.data.database.entities.PlaylistEntity
import io.github.kobych.mulo.domain.model.Playlist

fun PlaylistEntity.toDomain(): Playlist =
    Playlist(
        id = id,
        name = name,
    )

fun Playlist.toEntity(): PlaylistEntity =
    PlaylistEntity(
        id = id,
        name = name,
    )
