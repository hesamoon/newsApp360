package com.start.newsapp.dto.football_360_model

data class InstanceData(
    val away_penalty_score: Any,
    val away_score: Int,
    val away_team: AwayTeam,
    val country: CountryX,
    val full_title: String,
    val fullname: String,
    val holds_at: Int,
    val home_penalty_score: Any,
    val home_score: Int,
    val home_team: HomeTeam,
    val id: String,
    val image: String,
    val is_active: Boolean,
    val is_finished: Boolean,
    val is_national: Boolean,
    val is_postponed: Boolean,
    val kit_number: Int,
    val logo: String,
    val minute: Int,
    val person: Person,
    val position: Position,
    val round_type: RoundType,
    val slug: String,
    val spectators: Int,
    val status: Status,
    val thumbnail: String,
    val title: String,
    val to_be_decided: Boolean
)