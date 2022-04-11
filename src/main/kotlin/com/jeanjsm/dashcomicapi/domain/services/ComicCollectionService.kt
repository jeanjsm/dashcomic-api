package com.jeanjsm.dashcomicapi.domain.services

import com.jeanjsm.dashcomicapi.controller.vo.ComicCollectionVO
import com.jeanjsm.dashcomicapi.domain.entity.ComicCollection
import com.jeanjsm.dashcomicapi.domain.repository.ComicCollectionRepository
import java.math.BigDecimal
import org.springframework.stereotype.Service

@Service
class ComicCollectionService(
    private val repository: ComicCollectionRepository,
    private val collectionService: CollectionService,
    private val comicService: ComicService
) {

    fun findById(id: Long) : ComicCollection {
        return repository.findById(id).orElse(null)
    }

    fun addComicToCollection(comicCollectionVO: ComicCollectionVO, idCollection: Long): ComicCollection {
        val collection = collectionService.findById(idCollection) ?: throw Exception("Collection not found")

        val comicCollection = ComicCollection(
            collection = collection,
            name = comicCollectionVO.name!!,
            authorName = comicCollectionVO.authorName,
            year = comicCollectionVO.year,
            coverUrl = comicCollectionVO.coverUrl,
            completed = comicCollectionVO.completed,
            idMal = comicCollectionVO.idMal,
            idAnilist = comicCollectionVO.idAnilist
        )
        return repository.save(comicCollection)
    }

    fun updateTotalValue(comicCollection: ComicCollection, value: BigDecimal, amount: Int) {
        comicCollection.totalValue = comicCollection.totalValue.add(value)
        repository.save(comicCollection)
        collectionService.updateTotalValueAndTotalAmount(comicCollection.collection, value, amount)
    }

    fun getComicsByCollection(idCollection: Long): List<ComicCollectionVO> {
        val comicsCollection = repository.findByCollectionId(idCollection)
        return comicsCollection.map { ComicCollectionVO(it) }
    }

}
