package tech.timely.controller.dto

import org.springframework.data.annotation.Immutable
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Immutable
class EntryFormated(
    @Id
    private val id: Long,
    private val name: String,
    private val startDateTime: String,
    private val endDateTIme: String,
    private val duration: String
) {
//    constructor(entry: Entry): this(
//        name = entry.name,
//        startDateTime = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(entry.startDateTime),
//        endDateTIme = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(entry.endDateTime),
//        duration = entry.duration?.toHours()!!.toInt().toString() + "h "
//                + entry.duration.toMinutes()!!.toInt()%60 + "m "
//    )
}
