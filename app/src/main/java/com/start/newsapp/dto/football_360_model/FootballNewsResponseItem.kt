package com.start.newsapp.dto.football_360_model

import com.start.newsapp.model.football_model.PostModel

data class FootballNewsResponseItem(
    val default_cover: Any,
    val id: String,
    val key: String,
    val mobile_order: Int,
    val order: Int,
    val page: String,
    val posts: List<Post>,
    val redirect_to: Any,
    val section_type: SectionType,
    val section_type_mobile: SectionTypeMobile,
    val sort_by: String,
    val sort_order: String,
    val title: String
)

fun FootballNewsResponseItem.getFootballPostModel(): List<PostModel>{
    return posts.map {
        PostModel(
            id = it.post.code,
            title = it.post.title,
            body = it.post.sub_title,
            cover = it.post.primary_media,
            author = it.post.author.full_name,
            createdAt = it.post.created_at.toString()
        )
    }
}