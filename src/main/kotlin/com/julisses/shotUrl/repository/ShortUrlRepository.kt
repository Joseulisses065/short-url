package com.julisses.shotUrl.repository

import com.julisses.shotUrl.model.ShortUrl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ShortUrlRepository: JpaRepository<ShortUrl, UUID> {
    @Query("SELECT s FROM ShortUrl s WHERE s.shortCode = :shortCode")
    fun findShortUrlByShortCode(@Param("shortCode")shortCode:String): ShortUrl?
}