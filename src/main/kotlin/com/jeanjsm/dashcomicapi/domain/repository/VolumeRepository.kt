package com.jeanjsm.dashcomicapi.domain.repository

import com.jeanjsm.dashcomicapi.domain.entity.Volume
import org.springframework.data.jpa.repository.JpaRepository

interface VolumeRepository : JpaRepository<Volume, Long> {
    fun findByComicId(idComic: Long) : List<Volume>
}
