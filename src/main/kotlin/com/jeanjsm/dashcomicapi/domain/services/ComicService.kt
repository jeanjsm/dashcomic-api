package com.jeanjsm.dashcomicapi.domain.services

import com.jeanjsm.dashcomicapi.controller.vo.VolumeRequestVO
import com.jeanjsm.dashcomicapi.controller.vo.VolumeResponseVO
import com.jeanjsm.dashcomicapi.domain.entity.Comic
import com.jeanjsm.dashcomicapi.domain.entity.Volume
import com.jeanjsm.dashcomicapi.domain.repository.ComicRepository
import mu.KLogger
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ComicService(
    private val repository: ComicRepository,
    private val volumeService: VolumeService,
    private val log: KLogger = KotlinLogging.logger { }
) {

    fun create(comic: Comic) {
        log.info { "M=create, I=creating_comic, comic_name=${comic.name}" }
        repository.save(comic).also {
            log.info { "M=create, I=created_comic, comic_name=${comic.name}" }
        }
    }

    fun findById(id: Long): Comic {
        return repository.findByIdOrNull(id)!!
    }

    fun findAll(): List<Comic> {
        return repository.findAll()
    }

    fun findByName(name: String): List<Comic> {
        return repository.findByNameLike(name.lowercase().trim())
    }

    fun addVolume(idComic: Long, volumeRequestVO: VolumeRequestVO) {
        val comic = repository.findByIdOrNull(idComic) ?: throw Exception("Comic not found")
        val volume = Volume(
            comic = comic,
            number = volumeRequestVO.number,
            price = volumeRequestVO.price!!
        )
        volumeService.save(volume)
    }

    fun getVolumes(idComic: Long): List<VolumeResponseVO> {
        return volumeService.findByComicId(idComic).map { VolumeResponseVO(it) }
    }
}
