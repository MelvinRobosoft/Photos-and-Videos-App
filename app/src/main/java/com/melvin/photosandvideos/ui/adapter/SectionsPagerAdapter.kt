package com.melvin.photosandvideos.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.melvin.photosandvideos.R
import com.melvin.photosandvideos.ui.main.FavoritesFragment
import com.melvin.photosandvideos.ui.main.PhotosFragment
import com.melvin.photosandvideos.ui.main.VideosFragment

private val TAB_TITLES = arrayOf(
		R.string.tab_text_1,
		R.string.tab_text_2,
		R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context : Context, fm : FragmentManager) : FragmentPagerAdapter(fm) {
	
	override fun getItem(position : Int) : Fragment {
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class below).
		var fragment : Fragment? = null
		if (position == 0) {
			fragment = PhotosFragment()
		} else if (position == 1) {
			fragment = VideosFragment()
		} else if (position == 2) {
			fragment = FavoritesFragment()
		}
		return fragment!!
	}
	
	override fun getPageTitle(position : Int) : CharSequence? {
		return context.resources.getString(TAB_TITLES[position])
	}
	
	override fun getCount() : Int {
		// Show 3 total pages.
		return 3
	}
}