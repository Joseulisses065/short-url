package com.julisses.shotUrl.service

import com.julisses.shotUrl.data.vo.ShortUrlVo
import org.springframework.stereotype.Service
import java.util.UUID

@Service
interface ShortUrlService {
    fun create(shortUrlVo: ShortUrlVo): ShortUrlVo
    fun update(id: UUID, shortUrlVo1: ShortUrlVo):ShortUrlVo
    fun delete(id: UUID)
    fun findByCode(shortCode: String):ShortUrlVo
    fun findById(id: UUID):ShortUrlVo
    fun findAll():List<ShortUrlVo>
}