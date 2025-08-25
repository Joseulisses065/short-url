package com.julisses.shotUrl.service.implementation

import com.julisses.shotUrl.data.vo.ShortUrlVo
import com.julisses.shotUrl.model.ShortUrl
import com.julisses.shotUrl.repository.ShortUrlRepository
import com.julisses.shotUrl.service.ShortUrlService
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ShortUrlServiceImpl(private val shortUrlRepository: ShortUrlRepository): ShortUrlService {
    override fun create(shortUrlVo: ShortUrlVo): ShortUrlVo {
        val response = this.shortUrlRepository.save(ShortUrl(null,shortUrlVo.originalUrl,shortUrlVo.shortCode))
        return ShortUrlVo(response.id,response.originalUrl,response.shortCode)
    }

    override fun update(id: UUID, shortUrlVo1: ShortUrlVo): ShortUrlVo {
       var found = this.shortUrlRepository.findById(id).orElseThrow{ ChangeSetPersister.NotFoundException()}
        found.shortCode = shortUrlVo1.shortCode
        found.originalUrl = shortUrlVo1.originalUrl
        val response = this.shortUrlRepository.save(found)
        return ShortUrlVo(response.id,response.originalUrl,response.shortCode)
    }

    override fun delete(id: UUID) {
        val find = this.shortUrlRepository.findById(id).orElseThrow{ ChangeSetPersister.NotFoundException()}
        this.shortUrlRepository.delete(find)
    }

    override fun findByCode(shortCode: String): ShortUrlVo {
        val find = this.shortUrlRepository.findShortUrlByShortCode(shortCode)
        return ShortUrlVo(find?.id,find?.originalUrl,find?.shortCode)
    }

    override fun findById(id: UUID): ShortUrlVo {
        val find: ShortUrl = this.shortUrlRepository.findById(id).orElseThrow{ EntityNotFoundException() }
        return ShortUrlVo(find.id,find.originalUrl,find.shortCode)
    }

    override fun findAll(): List<ShortUrlVo> {
       return this.shortUrlRepository.findAll().map {
            i->
            ShortUrlVo(i.id,i.originalUrl,i.shortCode)
        }
    }
}