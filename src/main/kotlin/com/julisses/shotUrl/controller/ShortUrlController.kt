package com.julisses.shotUrl.controller

import com.julisses.shotUrl.data.vo.ShortUrlVo
import com.julisses.shotUrl.docs.ShortUrlControllerDocs
import com.julisses.shotUrl.service.ShortUrlService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.util.UUID

@RestController
@RequestMapping("/api/v1/shotUrls")
class ShortUrlController(private val shortUrlService: ShortUrlService): ShortUrlControllerDocs {


    @PostMapping()
    override fun create(@RequestBody @Valid shortUrlVo: ShortUrlVo): ResponseEntity<ShortUrlVo>{
        val shortUrl: ShortUrlVo = this.shortUrlService.create(shortUrlVo)
        val url: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(shortUrlVo.id).toUri()
        return ResponseEntity.created(url).body(shortUrl)
    }
    @PutMapping("/{id}")
    override fun update(@PathVariable id: UUID,@RequestBody @Valid shortUrlVo: ShortUrlVo): ResponseEntity<ShortUrlVo>{
        val shortUrl: ShortUrlVo = this.shortUrlService.update(id,shortUrlVo)
        return ResponseEntity.ok().body(shortUrl)
    }
    @DeleteMapping("/{id}")
    override fun delete(@PathVariable id: UUID): ResponseEntity<Void>{
        this.shortUrlService.delete(id);
        return ResponseEntity.noContent().build()

    }
    @GetMapping("/findByShortCode/{code}")
    override fun findByCode(@PathVariable code:String):ResponseEntity<ShortUrlVo>{
       val shortUrlVo =  this.shortUrlService.findByCode(code);
        return ResponseEntity.ok().body(shortUrlVo);
    }
    @GetMapping("/{id}")
    override fun findById(@PathVariable id: UUID):ResponseEntity<ShortUrlVo>{
        val shortUrlVo =  this.shortUrlService.findById(id);
        return ResponseEntity.ok().body(shortUrlVo);
    }
    @GetMapping()
    override fun findAll():ResponseEntity<List<ShortUrlVo>>{
        return ResponseEntity.ok().body(this.shortUrlService.findAll())

    }
}