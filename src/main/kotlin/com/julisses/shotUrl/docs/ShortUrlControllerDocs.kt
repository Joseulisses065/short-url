package com.julisses.shotUrl.docs

import com.julisses.shotUrl.data.vo.ShortUrlVo
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@Tag(name = "ShortUrl", description = "All features of short Url")
interface ShortUrlControllerDocs {
    @Operation(
        summary = "Create Shot Url", description = "Create Shot Url", tags = ["ShortUrl"], responses = [
            ApiResponse(
                description = "Created",
                responseCode = "201",
                content = [Content(schema = Schema(implementation = ShortUrlVo::class))
                ]
            )

        ]
    )
    fun create(@RequestBody @Valid shortUrlVo: ShortUrlVo): ResponseEntity<ShortUrlVo>
    fun update(@PathVariable id: UUID,@RequestBody @Valid shortUrlVo: ShortUrlVo):ResponseEntity<ShortUrlVo>
    fun delete(@PathVariable id: UUID):ResponseEntity<Void>
    fun findByCode(@PathVariable code:String):ResponseEntity<ShortUrlVo>
    fun findById(@PathVariable id: UUID):ResponseEntity<ShortUrlVo>
    fun findAll():ResponseEntity<List<ShortUrlVo>>
}