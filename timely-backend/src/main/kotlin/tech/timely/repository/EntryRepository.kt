package tech.timely.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.Repository
import tech.timely.model.Entry
import java.util.*

interface EntryRepository: Repository<Entry, UUID> {

    fun save(entry: Entry): Entry

    fun findAll(): List<Entry>

    fun deleteAll()

    fun findAll(pageable: Pageable): Page<Entry>

}