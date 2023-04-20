package com.start.newsapp.dto.football_360_model

data class PostX(
    val author: Author,
    val code: Int,
    val comment_count: Int,
    val created_at: Int,
    val hit_count: Int,
    val id: String,
    val is_published: Boolean,
    val link: String,
    val medias: List<Media>,
    val post_type: String,
    val primary_media: String,
    val published_at: Int,
    val slug: String,
    val sub_title: String,
    val super_title: Any,
    val tags: List<Tag>,
    val title: String,
    val view_count: Int
)