package io.github.kobych.mulo.data.database.repositories

import io.github.kobych.mulo.data.database.dao.PlaylistTrackDao
import io.github.kobych.mulo.data.database.entities.PlaylistTrackEntity
import io.github.kobych.mulo.data.mapper.toDomain
import io.github.kobych.mulo.domain.model.Track
import io.github.kobych.mulo.domain.repositories.PlaylistTrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlaylistTrackRepositoryImpl(
    private val playlistTrackDao: PlaylistTrackDao,
) : PlaylistTrackRepository {
    override suspend fun addTrackToPlaylist(
        playlistTrack: Track,
        playlistId: Int,
        position: Int,
    ) = playlistTrackDao.addTrackToPlaylist(
        PlaylistTrackEntity(
            playlistId = playlistId,
            trackId = playlistTrack.id,
            position = position,
        ),
    )

    override suspend fun changeTrackPosition(
        playlistId: Int,
        trackId: Int,
        newPosition: Int,
    ) = playlistTrackDao.changeTrackPosition(playlistId, trackId, newPosition)

    override fun observePlaylistTracks(playlistId: Int): Flow<List<Track>> =
        playlistTrackDao.observePlaylistTracks(
            playlistId = playlistId,
        ).map { list ->
            list.map { entity ->
                entity.toDomain()
            }
        }

    override suspend fun deleteTrackFromPlaylist(
        playlistId: Int,
        trackId: Int,
    ) = playlistTrackDao.deleteTrackFromPlaylist(
        playlistId = playlistId,
        trackId = trackId,
    )
}
