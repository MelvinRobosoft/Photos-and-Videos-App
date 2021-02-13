package com.melvin.photosandvideos.ui.adapter


import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin.photosandvideos.R
import com.melvin.photosandvideos.model.Photo
import com.melvin.photosandvideos.ui.main.Constant



class RecyclerViewAdapter(val items : ArrayList<Photo?>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
	
	override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : RecyclerView.ViewHolder {
		/*val view : View = LayoutInflater.from(parent.context).inflate(R.layout.photos_row_item, parent, false)
		return MyViewHolder(view)*/
		
		return if (viewType == Constant.VIEW_TYPE_ITEM) {
			val view = LayoutInflater.from(parent.context).inflate(R.layout.photos_row_item, parent, false)
			MyViewHolder(view)
		} else {
			val view = LayoutInflater.from(parent.context).inflate(R.layout.progress_loading, parent, false)
			LoadingViewHolder(view)
		}
	}
	
	fun addLoadingView(photos : List<Photo?>) {
		
		items.addAll(photos)
	}
	
	/*fun addLoadingView() {
		
		//Add loading item
		Handler().post {
			items.toMutableList().add(null)
			notifyItemInserted(items.size - 1)
		}
		
	}*/
	
	/*fun removeLoadingView() {
		//Remove loading item
		if (items.size != 0) {
			items.toMutableList().removeAt(items.size - 1)
			notifyItemRemoved(items.size)
		}
	}*/
	
	override fun onBindViewHolder(holder : RecyclerView.ViewHolder, position : Int) {
		
		if (holder.itemViewType == Constant.VIEW_TYPE_ITEM) {
			items[position]?.let { (holder as MyViewHolder) .bind(it) }
		}
		
	}
	
	
	override fun getItemId(position : Int) : Long {
		return position.toLong()
	}
	
	override fun getItemCount() : Int {
		return items.size
	}
	
	class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
		var title: TextView = itemView.findViewById(R.id.title)
		var photosImageView: ImageView = itemView.findViewById(R.id.photosImageView)
		
		fun bind(photo : Photo) {
			title.text = photo.photographer
			
			Glide.with(itemView.context)
					.load(photo.src.landscape)
					.into(photosImageView)
			
		}
		
	}
	
	class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
	
	
}
