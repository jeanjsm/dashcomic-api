package com.jeanjsm.dashcomicapi.domain.services

import com.jeanjsm.dashcomicapi.controller.vo.VolumeRequestVO
import com.jeanjsm.dashcomicapi.domain.entity.Volume
import com.jeanjsm.dashcomicapi.domain.entity.VolumeComicCollection
import com.jeanjsm.dashcomicapi.domain.repository.VolumeComicCollectionRepository
import java.math.BigDecimal
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

    fun addVolume(idComicCollection: Long, idVolume: Long, volumeRequestVO: VolumeRequestVO) {

        val comicCollection = comicCollectionService.findById(idComicCollection)

        val price = volumeRequestVO.price

        val volumeComicCollection = VolumeComicCollection(
            comicCollection = comicCollection,
            price = price ?: BigDecimal.ZERO,
            number = volumeRequestVO.number,
            dateAdded = volumeRequestVO.dateAdded ?: LocalDate.now()
        )
        save(volumeComicCollection)
        comicCollectionService.updateTotalValue(comicCollection, price!!, volumeRequestVO.amount ?: 1)
    }

    fun getVolumes(idComicCollection: Long): List<VolumeComicCollection> {
        val comicCollection = comicCollectionService.findById(idComicCollection)
        return repository.findByComicCollection(comicCollection)
    }

}
