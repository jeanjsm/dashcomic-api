package com.jeanjsm.dashcomicapi.domain.repository

import com.jeanjsm.dashcomicapi.domain.entity.Collection
import org.springframework.data.jpa.repository.JpaRepository

interface CollectionRepository : JpaRepository<Collection, Long>
