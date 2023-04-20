package com.start.newsapp.dto.post_model

data class PostModel(
    val body: String,
    val category: String,
    val cover: String,
    val createdAt: String,
    val id: Int,
    val isDraft: Boolean,
    val title: String,
    val views: Int
)