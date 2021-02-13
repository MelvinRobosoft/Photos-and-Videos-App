package com.melvin.photosandvideos.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melvin.photosandvideos.R
import com.melvin.photosandvideos.model.Photo
import com.melvin.photosandvideos.ui.adapter.RecyclerViewAdapter
import com.melvin.photosandvideos.viewmodel.PhotosViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [PhotosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PhotosFragment : Fragment() {
	
	var recyclerView : RecyclerView? = null
	lateinit var photosViewModel: PhotosViewModel
	lateinit var scrollListener: RecyclerViewLoadMoreScroll
	lateinit var adapter:RecyclerViewAdapter
	var loading : Boolean=false
	var page : Int=1
	
	@Nullable
	override fun onCreateView(inflater : LayoutInflater, @Nullable container : ViewGroup?, @Nullable savedInstanceState : Bundle?) : View? {
		return inflater.inflate(
				R.layout.fragment_photos, container, false
		)
	}
	
	override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		//val items = resources.getStringArray(R.array.tab_A)
		photosViewModel = ViewModelProvider(this).get(PhotosViewModel::class.java)
		
		recyclerView = view.findViewById<View>(R.id.recycler_view) as RecyclerView
		val layoutManager = LinearLayoutManager(context)
		recyclerView!!.setLayoutManager(layoutManager)
		
		scrollListener = RecyclerViewLoadMoreScroll(layoutManager)
		recyclerView!!.addOnScrollListener(scrollListener)
		
		adapter = RecyclerViewAdapter(arrayListOf<Photo?>())
		recyclerView!!.setAdapter(adapter)
		
		loadData(page)
		
		
		scrollListener.setOnLoadMoreListener(object : OnLoadMoreListener {
			override fun onLoadMore() {
				if(!loading){
					loading=true
					page++
					loadData(page)
				}
				
				
				
		}
		})
		
		
		
	}
	
	private fun loadData(int :Int) {
		photosViewModel.getPhotos(int)!!.observe(this, Observer { PhotosResponse ->
			loading=false
			adapter.addLoadingView(PhotosResponse.photos)
			adapter.notifyDataSetChanged()
			
			
		})
	}
	}
	
	
