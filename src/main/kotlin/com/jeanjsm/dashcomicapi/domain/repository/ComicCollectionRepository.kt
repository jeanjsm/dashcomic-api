package com.jeanjsm.dashcomicapi.domain.repository

import com.jeanjsm.dashcomicapi.domain.entity.ComicCollection
import org.springframework.data.jpa.repository.JpaRepository

interface ComicCollectionRepository : JpaRepository<ComicCollection, Long> {
    fun findByCollectionIdOrderByName(id: Long): List<ComicCollection>
}
