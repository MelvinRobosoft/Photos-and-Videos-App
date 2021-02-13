package com.melvin.photosandvideos.model

data class VideoResponse(val page : Int,
                         val per_page : Int,
                         val total_results : Int,
                         val url : String,
                         val videos : List<Videos>
)
