package com.scb.mobilephone.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.scb.mobilephone.ui.fragment.FavoriteFragment
import com.scb.mobilephone.ui.fragment.MobileFragment

private val TAB_TITLES = arrayOf(
    "MOBILE LIST",
    "FAVORITE LIST"
)

class SectionsPagerAdapter(val fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MobileFragment()
            else -> FavoriteFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return TAB_TITLES.count()
    }

    fun sortFunction(item: Int) {
        fm.fragments.forEach {
            if (it is MobileFragment){
                when(item){
                    0 -> it.sortPriceLowToHeight()
                    1 -> it.sortPriceHighToLow()
                    2 -> it.sortRatingFromHighToLow()
                }
            }else if (it is FavoriteFragment){
                when(item){
                    0 -> it.sortPriceLowToHeight()
                    1 -> it.sortPriceHighToLow()
                    2 -> it.sortRatingFromHighToLow()
                }
            }
        }
    }

    fun upDateFragmentData(){
        fm.fragments.forEach {
            if(it is MobileFragment){
                it.onDataChange()
            }else if (it is FavoriteFragment){
                it.submitDataChange()
            }
        }
    }

}