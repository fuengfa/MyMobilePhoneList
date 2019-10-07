package com.scb.mobilephone.ui.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.scb.mobilephone.R
import com.scb.mobilephone.ui.adapter.SectionsPagerAdapter
import com.scb.mobilephone.ui.model.AppDatbase
import com.scb.mobilephone.ui.model.CMWorkerThread
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(){

    private lateinit var mCMWorkerThread: CMWorkerThread
    private var mDatabaseAdapter: AppDatbase? = null
    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter
    private lateinit var alertDialog1: AlertDialog
    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialValue()
        createSectionPageAdapter()
        setTabListener()
        sortIt.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            var values =
                arrayOf<CharSequence>(" Price low to high ", " Price high to low ", " Rating 5-1 ")
            builder.setSingleChoiceItems(values, -1, DialogInterface.OnClickListener { _, item ->
                when (item) {
                    0 -> sectionsPagerAdapter.sortFunction(item)

                    1 -> sectionsPagerAdapter.sortFunction(item)

                    2 -> sectionsPagerAdapter.sortFunction(item)
                }
                alertDialog1.dismiss()
            })
            alertDialog1 = builder.create()
            alertDialog1.show()
        }
        setupDatabase()
        setupWorkerThread()
    }

    private fun setTabListener() {
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab?) {
                sectionsPagerAdapter.upDateFragmentData()
            }
        })
    }

    private fun setupWorkerThread() {
        mCMWorkerThread = CMWorkerThread("scb_database").also {
            it.start()
        }
    }

    private fun setupDatabase() {
        mDatabaseAdapter = AppDatbase.getInstance(this).also {
            it.openHelper.readableDatabase
        }
    }

    private fun initialValue() {
        viewPager = findViewById(R.id.view_pager)
        tabs = findViewById(R.id.tabs)
    }

    private fun createSectionPageAdapter() {
        sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }
}

interface OnSortClickListener {
    fun sortPriceLowToHeight()
    fun sortPriceHighToLow()
    fun sortRatingFromHighToLow()
}


