package com.jeanjsm.dashcomicapi.domain.services

import com.jeanjsm.dashcomicapi.domain.entity.Volume
import com.jeanjsm.dashcomicapi.domain.repository.VolumeRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class VolumeService(
    private val repository: VolumeRepository
) {

    fun save(volume: Volume): Volume {
        return repository.save(volume)
    }

    fun findAll() : List<Volume> {
        return repository.findAll()
    }

    fun findById(id: Long): Volume? {
        return repository.findByIdOrNull(id)
    }

    fun findByComicId(idComic: Long): List<Volume> {
        return repository.findByComicId(idComic)
    }

}
