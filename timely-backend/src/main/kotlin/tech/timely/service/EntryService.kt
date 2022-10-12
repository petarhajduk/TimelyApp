package tech.timely.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import tech.timely.controller.dto.EntryAdder
import tech.timely.model.Entry
import tech.timely.repository.EntryRepository
import java.time.Duration
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class EntryService(
    val entryRepository: EntryRepository
) {

    fun findAll(): List<Entry> {
        val formater = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
        val entry = entryRepository.findAll()
//        var hours: Int
//        var minutes: Int
//        println(entry)
//        val entryFormated = LinkedList<EntryFormated>()
//        for (e in entry){
//            println(e)
//            hours = e.duration.toHours().toInt()
//            minutes = e.duration.toMinutes().toInt()%60
//
//            entryFormated.add(EntryFormated(
//                name = e.name,
//                startDateTime = formater.format(e.startDateTime),
//                endDateTIme = formater.format(e.endDateTime),
//                duration = hours.toString() + "h " + minutes.toString() + "m", id = e.id))
//        }
        //println(entryFormated)
        return entry
    }

    fun addNew(entryAdder: EntryAdder): Entry {
        return entryRepository.save(
            Entry(id = UUID.randomUUID(), name = entryAdder.name, startDateTime = entryAdder.startDateTime,
                endDateTime = entryAdder.endDateTime, duration = Duration.between(entryAdder.startDateTime, entryAdder.endDateTime))
        )
    }

    fun deleteAll() {
        entryRepository.deleteAll()
    }

    fun getAllEntriesPaged(pageable: Pageable): Page<Entry> {
        return entryRepository.findAll(pageable)
    }

}