package com.melvin.photosandvideos.retrofit

import com.melvin.photosandvideos.model.PhotosResponse
import com.melvin.photosandvideos.model.VideoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PhotosService {
	
	
	@Headers("Authorization: " + "563492ad6f9170000100000116473c42480e4c8c9688bc8080c37afc")
	@GET("v1/search")
	fun getSearch(@Query("query") query: String?, @Query("per_page") itemNum: Int, @Query("page") numPage: Int): Call<PhotosResponse>
	
	
	@Headers("Authorization: " + "563492ad6f9170000100000116473c42480e4c8c9688bc8080c37afc")
	@GET("videos/search")
	fun getVideos(@Query("query") query: String?, @Query("per_page") itemNum: Int, @Query("page") numPage: Int): Call<VideoResponse>
}