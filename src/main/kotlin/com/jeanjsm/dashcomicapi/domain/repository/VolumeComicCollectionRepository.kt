package com.jeanjsm.dashcomicapi.domain.repository

import com.jeanjsm.dashcomicapi.domain.entity.ComicCollection
import com.jeanjsm.dashcomicapi.domain.entity.VolumeComicCollection
import org.springframework.data.jpa.repository.JpaRepository

interface VolumeComicCollectionRepository: JpaRepository<VolumeComicCollection, Long> {
    fun findByComicCollection(comicCollection: ComicCollection?): List<VolumeComicCollection>
}
