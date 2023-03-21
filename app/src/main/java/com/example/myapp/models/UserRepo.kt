package com.example.myapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "userrepo")
data class UserRepo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var userName: String,
    var repoName: String,
    )