package com.jeanjsm.dashcomicapi.domain.repository

import com.jeanjsm.dashcomicapi.domain.entity.Collection
import com.jeanjsm.dashcomicapi.domain.entity.Comic
import com.jeanjsm.dashcomicapi.domain.entity.ComicCollection
import org.springframework.data.jpa.repository.JpaRepository

interface ComicCollectionRepository : JpaRepository<ComicCollection, Long> {
    fun findByCollectionId(id: Long): List<ComicCollection>
    fun findByComicAndCollection(comic: Comic, collection: Collection): ComicCollection?
}
