package io.github.kobych.mulo.domain.repositories

import io.github.kobych.mulo.domain.model.Track
import kotlinx.coroutines.flow.Flow

interface TrackRepository {
    fun observeTracks(): Flow<List<Track>>

    suspend fun getTrackById(id: Int): Track?

    suspend fun addTrack(track: Track)

    suspend fun deleteTrack(track: Track)
}
