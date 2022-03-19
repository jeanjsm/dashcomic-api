package com.jeanjsm.dashcomicapi.controller

import com.jeanjsm.dashcomicapi.controller.vo.ComicResponseSearchVO
import com.jeanjsm.dashcomicapi.controller.vo.VolumeRequestVO
import com.jeanjsm.dashcomicapi.controller.vo.VolumeResponseVO
import com.jeanjsm.dashcomicapi.domain.entity.Comic
import com.jeanjsm.dashcomicapi.domain.entity.Volume
import com.jeanjsm.dashcomicapi.domain.services.ComicService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/comic")
@Tag(name = "Comic Controller")
class ComicController(
    private val service: ComicService
) {

    @GetMapping("/all")
    fun getComics(): List<Comic> {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun getComic(@PathVariable id: Long): Comic? {
        return service.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody comic: Comic) {
        service.create(comic)
    }

    @GetMapping()
    fun findByName(@RequestParam name: String): List<Comic> {
        return service.findByName(name)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{idComic}/add-volume")
    fun addVolume(@PathVariable idComic: Long, @RequestBody volume: VolumeRequestVO) {
        service.addVolume(idComic, volume)
    }

    @GetMapping("/{idComic}/volumes")
    fun getVolumes(@PathVariable idComic: Long): List<VolumeResponseVO> {
        return service.getVolumes(idComic)
    }

    @GetMapping("/search")
    fun search(@RequestParam search: String): List<ComicResponseSearchVO>? {
        return service.search(search)
    }

}
