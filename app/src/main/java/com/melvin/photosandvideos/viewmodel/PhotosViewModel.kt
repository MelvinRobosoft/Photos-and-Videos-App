package com.melvin.photosandvideos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.photosandvideos.model.PhotosResponse
import com.melvin.photosandvideos.model.VideoResponse
import com.melvin.photosandvideos.repository.MainActivityRepository

class PhotosViewModel : ViewModel() {
	
	var photosLiveData: MutableLiveData<PhotosResponse>? = null
	
	
	fun getPhotos(pageno:Int) : LiveData<PhotosResponse>? {
		photosLiveData = MainActivityRepository.getPhotos(pageno)
		return photosLiveData
	}
	
	
	
}