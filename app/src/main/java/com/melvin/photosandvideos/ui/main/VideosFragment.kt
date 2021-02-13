package com.melvin.photosandvideos.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melvin.photosandvideos.R
import com.melvin.photosandvideos.ui.adapter.VideoRecyclerViewAdapter
import com.melvin.photosandvideos.viewmodel.PhotosViewModel
import com.melvin.photosandvideos.viewmodel.VideosViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [VideosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideosFragment : Fragment() {
	// 563492ad6f9170000100000116473c42480e4c8c9688bc8080c37afc
	var recyclerView : RecyclerView? = null
	lateinit var videosViewModel: VideosViewModel
	lateinit var scrollListener: RecyclerViewLoadMoreScroll
	lateinit var adapter: VideoRecyclerViewAdapter
	
	@Nullable
	override fun onCreateView(inflater : LayoutInflater, @Nullable container : ViewGroup?, @Nullable savedInstanceState : Bundle?) : View? {
		return inflater.inflate(
				R.layout.fragment_photos, container, false
		)
	}
	
	override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		//val items = resources.getStringArray(R.array.tab_A)
		videosViewModel = ViewModelProvider(this).get(VideosViewModel::class.java)
		
		recyclerView = view.findViewById<View>(R.id.recycler_view) as RecyclerView
		val layoutManager = LinearLayoutManager(context)
		recyclerView!!.setLayoutManager(layoutManager)
		
		scrollListener = RecyclerViewLoadMoreScroll(layoutManager)
		recyclerView!!.addOnScrollListener(scrollListener)
		
		
		videosViewModel.getVideos(1)!!.observe(this, Observer { PhotosResponse ->
			
			//wp7progressBar.hideProgressBar()
			
			val msg = PhotosResponse.total_results
			//title.text=""+msg
			//lblResponse.text = msg
			
			adapter = VideoRecyclerViewAdapter(PhotosResponse.videos)
			recyclerView!!.setAdapter(adapter)
			
		})
		
		/*adapterLinear.removeLoadingView()
		//We adding the data to our main ArrayList
		adapterLinear.addData(loadMoreItemsCells)
		//Change the boolean isLoading to false
		scrollListener.setLoaded()*/
		
		
		scrollListener.setOnLoadMoreListener(object : OnLoadMoreListener {
			override fun onLoadMore() {
				//adapter.addLoadingView()
				/*mainActivityViewModel.getUser(1)!!.observe(this@PhotosFragment, Observer { PhotosResponse ->
					//adapter.removeLoadingView()
					
					adapter.addLoadingView(PhotosResponse.photos)
					adapter.notifyDataSetChanged()
					//wp7progressBar.hideProgressBar()
				})*/
				
			}
		})
		
		
	}
	
	
}