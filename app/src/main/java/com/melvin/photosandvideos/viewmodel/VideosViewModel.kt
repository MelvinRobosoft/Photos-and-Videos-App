package com.melvin.photosandvideos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.photosandvideos.model.PhotosResponse
import com.melvin.photosandvideos.model.VideoResponse
import com.melvin.photosandvideos.repository.MainActivityRepository

class VideosViewModel : ViewModel() {
	
	
	var VideosLiveData: MutableLiveData<VideoResponse>? = null
	
	
	
	fun getVideos(pageno:Int) : LiveData<VideoResponse>? {
		VideosLiveData = MainActivityRepository.getvideos(pageno)
		return VideosLiveData
	}
	
}