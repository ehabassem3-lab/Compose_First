package com.example.compose_first.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class SourcesItem(

	@field:SerializedName("country")
	val country: String? = null,

@ColumnInfo	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@PrimaryKey @ColumnInfo	@field:SerializedName("id")
	val id: String = "null",

	@ColumnInfo	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)