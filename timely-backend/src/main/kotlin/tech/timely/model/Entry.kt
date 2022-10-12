package tech.timely.model

import java.time.Duration
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "timelyinserts")
data class Entry(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    val id: UUID,

    val name: String,

    @Column(name = "startdatetime")
    val startDateTime: LocalDateTime,

    @Column(name = "enddatetime")
    val endDateTime: LocalDateTime,

    val duration: Duration
)