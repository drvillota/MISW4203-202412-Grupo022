package com.example.vinilosapp.models

import java.sql.Date
import java.sql.Timestamp

data class Album(
    var albumId: Int? = null,
    var name: String? = null,
    var cover: String? = null,
    var releaseDate: String? = null,
    var description: String? = null,
    var genre: String? = null,
    var recordLabel: String? = null,
)