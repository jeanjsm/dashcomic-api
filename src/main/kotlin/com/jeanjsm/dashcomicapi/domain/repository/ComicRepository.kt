package com.jeanjsm.dashcomicapi.domain.repository

import com.jeanjsm.dashcomicapi.domain.entity.Comic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ComicRepository : JpaRepository<Comic, Long> {

    @Query("select c from Comic c where LOWER(c.name) LIKE %:name%")
    fun findByNameLike(name: String): List<Comic>

}
