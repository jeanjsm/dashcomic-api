package com.jeanjsm.dashcomicapi.domain.repository

import com.jeanjsm.dashcomicapi.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
