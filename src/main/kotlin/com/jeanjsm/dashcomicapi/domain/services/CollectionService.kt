package com.jeanjsm.dashcomicapi.domain.services

import com.jeanjsm.dashcomicapi.domain.entity.Collection
import com.jeanjsm.dashcomicapi.domain.repository.CollectionRepository
import java.math.BigDecimal
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CollectionService(
    private val repository: CollectionRepository
) {

    fun getAll() : List<Collection> {
        return repository.findAll()
    }

    fun findById(id: Long): Collection? {
        return repository.findByIdOrNull(id)
    }

    fun updateTotalValueAndTotalAmount(collection: Collection, value: BigDecimal) {
        collection.totalAmount = collection.totalAmount++
        collection.totalValue = collection.totalValue.add(value)
        repository.save(collection)
    }

}
