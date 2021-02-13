package com.melvin.photosandvideos.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.melvin.photosandvideos.model.PhotosResponse
import com.melvin.photosandvideos.model.VideoResponse
import com.melvin.photosandvideos.retrofit.PhotosService
import com.melvin.photosandvideos.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {
	
	val PhotoObject = MutableLiveData<PhotosResponse>()
	val VideosObject = MutableLiveData<VideoResponse>()
	
	fun getPhotos(pageno:Int) : MutableLiveData<PhotosResponse> {
		
		
		
		
		val call = RetrofitClient.getRetrofitInstance()?.create(PhotosService::class.java)?.getSearch("animal", 10, pageno)
		
		
		
		
		
		
		call?.enqueue(object : Callback<PhotosResponse> {
			override fun onFailure(call : Call<PhotosResponse>, t : Throwable) {
				// TODO("Not yet implemented")
				Log.v("DEBUG : ", t.message.toString())
			}
			
			override fun onResponse(
					call : Call<PhotosResponse>,
					response : Response<PhotosResponse>
			) {
				// TODO("Not yet implemented")
				Log.v("DEBUG : ", response.body().toString())
				
				val data = response.body()
				
				//val msg = data!!.message
				
				PhotoObject.value = response.body()
			}
		})
		
		return PhotoObject
	}
	
	
	fun getvideos(pageno:Int) : MutableLiveData<VideoResponse> {
		
		val call2 = RetrofitClient.getRetrofitInstance()?.create(PhotosService::class.java)?.getVideos("animal", 10, pageno)
		
		
		
		call2?.enqueue(object : Callback<VideoResponse> {
			override fun onFailure(call : Call<VideoResponse>, t : Throwable) {
				// TODO("Not yet implemented")
				Log.v("DEBUG : ", t.message.toString())
			}
			
			override fun onResponse(
					call : Call<VideoResponse>,
					response : Response<VideoResponse>
			) {
				// TODO("Not yet implemented")
				Log.v("DEBUG : ", response.body().toString())
				
				val data = response.body()
				
				//val msg = data!!.message
				
				VideosObject.value = response.body()
			}
		})
		
		return VideosObject
	}
}
