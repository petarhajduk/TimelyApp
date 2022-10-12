package tech.timely.controller

import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.PagedModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.timely.controller.dto.EntryAdder
import tech.timely.controller.dto.EntryResource
import tech.timely.controller.dto.EntryResourceAssembler
import tech.timely.model.Entry
import tech.timely.service.EntryService

@RestController
class EntryController(
    private val entryService: EntryService,
    private val entryResourceAssembler: EntryResourceAssembler
) {

    @GetMapping("/get-all")
    @ResponseBody
    fun getAll(): ResponseEntity<CollectionModel<EntryResource>> {
        return ResponseEntity.ok(
            entryResourceAssembler.toCollectionModel(entryService.findAll())
        )
    }

    @PostMapping("/add-new")
    @ResponseBody
    fun addNew(@RequestBody entryAdder: EntryAdder): ResponseEntity<EntryResource> {
        return ResponseEntity.ok(
            entryResourceAssembler.toModel(entryService.addNew(entryAdder))
        )
    }

    @DeleteMapping("/delete")
    @ResponseBody
    fun deleteAll() {
        entryService.deleteAll()
    }

    @GetMapping("/get-entries-paged")
    @ResponseBody
    fun getAllEntriesPaged(
        pageable: Pageable,
        pagedResourcesAssembler: PagedResourcesAssembler<Entry>
    ): ResponseEntity<PagedModel<EntryResource>> {
        return ResponseEntity.ok(
            pagedResourcesAssembler.toModel(
                entryService.getAllEntriesPaged(pageable),
                entryResourceAssembler
            )
        )
    }
}