package io.github.kobych.mulo.data.mapper

import io.github.kobych.mulo.data.database.entities.TrackEntity
import io.github.kobych.mulo.domain.model.Track

fun TrackEntity.toDomain(): Track =
    Track(
        id = id,
        title = title,
        artist = artist,
        album = album,
        duration = duration,
        uri = uri,
        hash = hash,
    )

fun Track.toEntity(): TrackEntity =
    TrackEntity(
        id = id,
        title = title,
        artist = artist,
        album = album,
        duration = duration,
        uri = uri,
        hash = hash,
    )
