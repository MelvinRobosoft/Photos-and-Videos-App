package com.melvin.photosandvideos.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
	
	const val MainServer = "https://api.pexels.com/"
	private var retrofit : Retrofit? = null
	
	
	
	fun getRetrofitInstance() : Retrofit? {
		if (retrofit == null) {
			retrofit = Retrofit.Builder()
					.baseUrl(MainServer)
					.addConverterFactory(GsonConverterFactory.create())
					.build()
		}
		return retrofit
	}
	
	/*val retrofitClient: Retrofit.Builder by lazy {
		
		
		Retrofit.Builder()
				.baseUrl(MainServer)
				.addConverterFactory(GsonConverterFactory.create())
	}
	
	val apiInterface: PhotosService by lazy {
		retrofitClient
				.build()
				.create(PhotosService::class.java)
	}*/
}
