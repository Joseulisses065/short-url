package com.julisses.shotUrl.data.vo

import java.util.UUID


data class ShortUrlVo(
    val id: UUID? = null,
    val originalUrl:String? = null,
    val shortCode:String? = null
)
