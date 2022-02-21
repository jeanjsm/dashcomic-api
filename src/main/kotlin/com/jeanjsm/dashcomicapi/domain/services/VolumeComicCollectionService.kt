package com.jeanjsm.dashcomicapi.domain.services

import com.jeanjsm.dashcomicapi.controller.vo.VolumeRequestVO
import com.jeanjsm.dashcomicapi.domain.entity.Volume
import com.jeanjsm.dashcomicapi.domain.entity.VolumeComicCollection
import com.jeanjsm.dashcomicapi.domain.repository.VolumeComicCollectionRepository
import java.time.LocalDate
import org.springframework.stereotype.Service

@Service
class VolumeComicCollectionService(
    private val repository: VolumeComicCollectionRepository,
    private val volumeService: VolumeService,
    private val comicCollectionService: ComicCollectionService
) {

    fun save(volumeComicCollection: VolumeComicCollection) {
        repository.save(volumeComicCollection)
    }

    fun remove(id: Long) {
        repository.deleteById(id)
    }

    fun addVolume(idCollection: Long, idComic: Long, idVolume: Long, volumeRequestVO: VolumeRequestVO) {
        val volume = volumeService.findById(idVolume) ?: throw Exception("Volume not found")

        val comicCollection = comicCollectionService.addComicToCollection(idComic, idCollection)

        val price = volumeRequestVO.price ?: volume.price

        val volumeComicCollection = VolumeComicCollection(
            volume = volume,
            comicCollection = comicCollection,
            price = price,
            dateAdded = volumeRequestVO.dateAdded ?: LocalDate.now()
        )
        save(volumeComicCollection)
        comicCollectionService.updateTotalValue(comicCollection, price, volumeRequestVO.amount ?: 1)
    }

    fun getVolumes(idCollection: Long, idComic: Long): List<Volume> {
        val comicCollection = comicCollectionService.getComicCollectionByComicAndCollection(idCollection, idComic)
        return repository.findByComicCollection(comicCollection).map { it.volume }
    }

}
