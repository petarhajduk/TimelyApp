package tech.timely.controller.dto

import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.IanaLinkRelations
import org.springframework.hateoas.RepresentationModel
import org.springframework.hateoas.server.core.Relation
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.stereotype.Component
import tech.timely.controller.EntryController
import tech.timely.model.Entry
import java.time.format.DateTimeFormatter

@Component
class EntryResourceAssembler : RepresentationModelAssemblerSupport<Entry, EntryResource>(
    EntryController::class.java, EntryResource::class.java
) {

    private val noPagination = Pageable.unpaged()
    private val nullAssembler = PagedResourcesAssembler<Entry>(null, null)

    override fun toModel(entity: Entry): EntryResource {
        return createModelWithId(entity.id, entity).apply {
            add(
                linkTo<EntryController> {
                    getAll()
                }.withRel("timelyinserts")
            )
        }
    }

    override fun instantiateModel(entity: Entry): EntryResource {
        val formater = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
        val minutes = entity.duration.toMinutes()%60
        return EntryResource(
            name = entity.name,
            startDateTime = formater.format(entity.startDateTime),
            endDateTime = formater.format(entity.endDateTime),
            duration = entity.duration.toHours().toString() + " h " + minutes.toString() + " m"
        )
    }

}

@Relation(collectionRelation = IanaLinkRelations.ITEM_VALUE)
data class EntryResource(
    val name: String,
    val startDateTime: String,
    val endDateTime: String,
    val duration: String
): RepresentationModel<EntryResource>()