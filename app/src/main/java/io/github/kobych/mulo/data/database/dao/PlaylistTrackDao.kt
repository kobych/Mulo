package io.github.kobych.mulo.data.database.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.Query
import io.github.kobych.mulo.data.database.entities.PlaylistTrackEntity
import io.github.kobych.mulo.data.database.entities.TrackEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaylistTrackDao {
    @Insert
    suspend fun addTrackToPlaylist(playlistTrack: PlaylistTrackEntity)

    @Query(
        """
            UPDATE playlist_tracks
            SET position = :newPosition
            WHERE playlistId = :playlistId
            AND trackId = :trackId
            """,
    )
    suspend fun changeTrackPosition(
        playlistId: Int,
        trackId: Int,
        newPosition: Int,
    )

    @Query(
        """
        SELECT tracks.*
        FROM playlist_tracks
        JOIN tracks ON playlist_tracks.trackId = tracks.id
        WHERE playlist_tracks.playlistId = :playlistId
        ORDER BY playlist_tracks.position ASC
        """,
    )
    fun observePlaylistTracks(playlistId: Int): Flow<List<TrackEntity>>

    @Query("DELETE FROM playlist_tracks WHERE playlistId = :playlistId AND trackId = :trackId")
    suspend fun deleteTrackFromPlaylist(
        playlistId: Int,
        trackId: Int,
    )
}
