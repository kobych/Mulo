package io.github.kobych.mulo.domain.repositories

import io.github.kobych.mulo.domain.model.Playlist
import kotlinx.coroutines.flow.Flow

interface PlaylistRepository {
    suspend fun getPlaylistById(id: Int): Playlist?

    suspend fun deletePlaylist(playlist: Playlist)

    suspend fun updatePlaylist(playlist: Playlist)

    suspend fun createPlaylist(playlist: Playlist): Int

    fun observePlaylists(): Flow<List<Playlist>>
}
