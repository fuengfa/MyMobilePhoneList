package com.scb.mobilephone.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.scb.mobilephone.ui.fragment.PicturesFragment
import com.scb.mobilephone.ui.model.Pictures

class PhotoPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var imgArray: List<Pictures> = listOf()
    fun setImage(imgArray: List<Pictures>){
        this.imgArray = imgArray
        notifyDataSetChanged()
    }
    override fun getItem(position: Int): Fragment {
        val fragment = PicturesFragment()
        val args = Bundle()
        args.putString("imgUrl", imgArray[position].url)
        fragment.arguments = args
        return fragment
        }

    override fun getCount(): Int {
        return imgArray.count()
    }
}