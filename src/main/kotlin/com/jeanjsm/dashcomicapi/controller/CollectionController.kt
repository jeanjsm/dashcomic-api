package com.jeanjsm.dashcomicapi.controller

import com.jeanjsm.dashcomicapi.controller.vo.CollectionVO
import com.jeanjsm.dashcomicapi.controller.vo.ComicCollectionVO
import com.jeanjsm.dashcomicapi.controller.vo.VolumeComicCollectionResponseVO
import com.jeanjsm.dashcomicapi.controller.vo.VolumeRequestVO
import com.jeanjsm.dashcomicapi.domain.entity.Comic
import com.jeanjsm.dashcomicapi.domain.entity.Volume
import com.jeanjsm.dashcomicapi.domain.entity.VolumeComicCollection
import com.jeanjsm.dashcomicapi.domain.services.CollectionService
import com.jeanjsm.dashcomicapi.domain.services.ComicCollectionService
import com.jeanjsm.dashcomicapi.domain.services.VolumeComicCollectionService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/collection")
@Tag(name = "Collection")
class CollectionController(
    private val service: CollectionService,
    private val comicCollectionService: ComicCollectionService,
    private val volumeComicCollectionService: VolumeComicCollectionService
) {

    @GetMapping
    fun findAll(): List<CollectionVO> {
        return service.getAll().map { CollectionVO(it) }
    }

    @GetMapping("/{id}")
    fun getCollection(@PathVariable id: Long): CollectionVO {
        val collection = service.findById(id) ?: throw Exception("Collection not found")
        return CollectionVO(collection)
    }

    @PostMapping("/{idCollection}/add-comic")
    fun addComicToCollection(@PathVariable idCollection: Long, @RequestBody comicCollectionVO: ComicCollectionVO) {
        comicCollectionService.addComicToCollection(comicCollectionVO, idCollection)
    }

    @GetMapping("/{id}/comics")
    fun getComicsByCollection(@PathVariable id: Long) : List<ComicCollectionVO> {
        return comicCollectionService.getComicsByCollection(id)
    }

    @PostMapping("/comic/{idComicCollection}/add-volume/{idVolume}")
    fun addVolumeToComicCollection(
        @PathVariable idComicCollection: Long,
        @RequestBody volumeRequestVO: VolumeRequestVO
    ) {
        volumeComicCollectionService.addVolume(idComicCollection, volumeRequestVO)
    }

    @DeleteMapping("/volume/{idVolume}")
    fun deleteVolume(@PathVariable idVolume: Long) {
        volumeComicCollectionService.remove(idVolume)
    }

    @GetMapping("/comic/{idComicCollection}/volumes")
    fun getVolumesFromComicCollection(
        @PathVariable idComicCollection: Long
    ): List<VolumeComicCollectionResponseVO> {
        return volumeComicCollectionService.getVolumes(idComicCollection)
    }

}
