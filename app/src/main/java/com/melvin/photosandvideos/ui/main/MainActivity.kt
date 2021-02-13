package com.melvin.photosandvideos.ui.main

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.melvin.photosandvideos.R
import com.melvin.photosandvideos.ui.adapter.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {
	
	lateinit var context: Context
	//lateinit var title: TextView
	
	
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
		val viewPager : ViewPager = findViewById(R.id.view_pager)
		viewPager.adapter = sectionsPagerAdapter
		val tabs : TabLayout = findViewById(R.id.tabs)
		tabs.setSelectedTabIndicatorColor(Color.parseColor("#E81244"));
		tabs.setTabTextColors(Color.parseColor("#230735"), Color.parseColor("#E81244"));
		
		
		
		
		tabs.setupWithViewPager(viewPager)
		//title=findViewById(R.id.title)
		
		
		
		
		context = this@MainActivity
		
		
		
	}
}