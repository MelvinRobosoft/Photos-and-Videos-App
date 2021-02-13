package com.melvin.photosandvideos.model

data class Videos (
	val full_res : String,
	val tags : List<String>,
	val id : Int,
	val width : Int,
	val height : Int,
	val url : String,
	val image : String,
	val duration : Int,
	val avg_color : String,
	val user : User,
	val video_files : List<Video_files>,
	val video_pictures : List<Video_pictures>

)
