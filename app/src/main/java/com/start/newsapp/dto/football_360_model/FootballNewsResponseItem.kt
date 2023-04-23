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
            id =   if(it.post.code != null) it.post.code else 0,
            title = if(it.post.title != null) it.post.title else "",
            body = if(it.post.sub_title != null) it.post.sub_title else "",
            cover = if(it.post.primary_media != null) it.post.primary_media else "",
            author = if(it.post.author.full_name != null) it.post.author.full_name else "",
            createdAt = if(it.post.created_at != null) it.post.created_at.toString() else ""
        )
    }
}