package com.jeanjsm.dashcomicapi.domain.services

import com.jeanjsm.dashcomicapi.controller.vo.ComicCollectionVO
import com.jeanjsm.dashcomicapi.domain.entity.Comic
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

    fun addComicToCollection(idComic: Long, idCollection: Long): ComicCollection {
        val comic = comicService.findById(idComic)
        val collection = collectionService.findById(idCollection) ?: throw Exception("Collection not found")

        val comicCollectionDB = repository.findByComicAndCollection(comic, collection)
        if (comicCollectionDB == null) {
            val comicCollection = ComicCollection(
                comic = comic,
                collection = collection
            )
            return repository.save(comicCollection )
        }
        return comicCollectionDB
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

    fun getComicCollectionByComicAndCollection(idCollection: Long, idComic: Long): ComicCollection? {
        val comic = comicService.findById(idComic)
        val collection = collectionService.findById(idCollection) ?: throw Exception("Collection not found")

        return repository.findByComicAndCollection(comic, collection)
    }

}
