package io.github.kobych.mulo.domain.repositories

import io.github.kobych.mulo.domain.model.Track
import kotlinx.coroutines.flow.Flow

interface PlaylistTrackRepository {
    suspend fun addTrackToPlaylist(
        playlistTrack: Track,
        playlistId: Int,
        position: Int,
    )

    suspend fun changeTrackPosition(
        playlistId: Int,
        trackId: Int,
        newPosition: Int,
    )

    fun observePlaylistTracks(playlistId: Int): Flow<List<Track>>

    suspend fun deleteTrackFromPlaylist(
        playlistId: Int,
        trackId: Int,
    )
}
