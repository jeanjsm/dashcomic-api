package com.jeanjsm.dashcomicapi.controller

import com.jeanjsm.dashcomicapi.integration.anilist.AnilistMediaService
import com.jeanjsm.dashcomicapi.integration.anilist.vo.AnilistMediaResponseVO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/anilist-test")
class AnilistTestController(
    private val anilistMediaService: AnilistMediaService
) {

    @GetMapping
    fun get(): AnilistMediaResponseVO? {
        return anilistMediaService.getMedia("samurai x")
    }

}
