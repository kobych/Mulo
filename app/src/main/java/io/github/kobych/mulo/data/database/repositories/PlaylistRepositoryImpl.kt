package io.github.kobych.mulo.data.database.repositories

import io.github.kobych.mulo.data.database.dao.PlaylistDao
import io.github.kobych.mulo.data.mapper.toDomain
import io.github.kobych.mulo.data.mapper.toEntity
import io.github.kobych.mulo.domain.model.Playlist
import io.github.kobych.mulo.domain.repositories.PlaylistRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlaylistRepositoryImpl(
    private val playlistDao: PlaylistDao,
) : PlaylistRepository {
    override fun observePlaylists(): Flow<List<Playlist>> =
        playlistDao.getAllPlaylists().map { list ->
            list.map { entity ->
                entity.toDomain()
            }
        }

    override suspend fun getPlaylistById(id: Int): Playlist? = playlistDao.getPlaylistById(id)?.toDomain()

    override suspend fun deletePlaylist(playlist: Playlist) = playlistDao.deletePlaylist(playlist.toEntity())

    override suspend fun updatePlaylist(playlist: Playlist) = playlistDao.updatePlaylist(playlist.toEntity())

    override suspend fun createPlaylist(playlist: Playlist): Int = playlistDao.createPlaylist(playlist.toEntity())
}
