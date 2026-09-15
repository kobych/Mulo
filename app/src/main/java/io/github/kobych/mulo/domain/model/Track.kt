package io.github.kobych.mulo.domain.model

data class Track(
    val id: Int,
    val title: String,
    val artist: String,
    val album: String,
    val duration: Long,
    val uri: String,
    val hash: String,
)
