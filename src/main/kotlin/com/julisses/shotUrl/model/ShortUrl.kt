package com.julisses.shotUrl.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID


@Entity
@Table(name="short_url")
data class ShortUrl(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    @Column(name = "original_url", unique = true, nullable = false)
    var originalUrl:String?,
    @Column(name = "short_code", unique = true, nullable = false)
    var shortCode:String?
)
