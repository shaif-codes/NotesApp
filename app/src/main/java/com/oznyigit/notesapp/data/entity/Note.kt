package com.oznyigit.notesapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
data class Note(@PrimaryKey(autoGenerate = true)
                @ColumnInfo("id") var id: Int,
                @ColumnInfo("title") var title: String,
                @ColumnInfo("content") var content: String) : Serializable