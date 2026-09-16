package io.github.kobych.mulo.data.database.repositories

import io.github.kobych.mulo.data.database.dao.TrackDao
import io.github.kobych.mulo.data.mapper.toDomain
import io.github.kobych.mulo.data.mapper.toEntity
import io.github.kobych.mulo.domain.model.Track
import io.github.kobych.mulo.domain.repositories.TrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TrackRepositoryImpl(
    private val trackDao: TrackDao,
) : TrackRepository {
    override fun observeTracks(): Flow<List<Track>> =
        trackDao
            .getAllTracks()
            .map { list ->
                list.map { entity ->
                    entity.toDomain()
                }
            }

    override suspend fun addTrack(track: Track) = trackDao.addTrack(track.toEntity())

    override suspend fun deleteTrack(track: Track) = trackDao.deleteTrack(track.toEntity())

    override suspend fun getTrackById(id: Int): Track? = trackDao.getTrackById(id)?.toDomain()
}
