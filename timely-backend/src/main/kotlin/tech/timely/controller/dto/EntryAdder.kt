package tech.timely.controller.dto

import java.time.LocalDateTime

class EntryAdder(
    val name: String,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime
) {
}