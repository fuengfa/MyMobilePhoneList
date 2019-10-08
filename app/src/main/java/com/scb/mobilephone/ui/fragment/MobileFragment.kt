package com.scb.mobilephone.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scb.mobilephone.R
import com.scb.mobilephone.ui.dagger.ProviderClass.LogString
import com.scb.mobilephone.ui.activity.MobileDetailActivity
import com.scb.mobilephone.ui.activity.OnSortClickListener
import com.scb.mobilephone.ui.adapter.MobileAdapter
import com.scb.mobilephone.ui.adapter.OnMobileClickListener
import com.scb.mobilephone.ui.model.AppDatbase
import com.scb.mobilephone.ui.model.MobileModel
import com.scb.mobilephone.ui.model.showToast
import kotlinx.android.synthetic.main.fragment_mobile.*
import javax.inject.Inject

class MobileFragment : BaseFragement(),
    OnMobileClickListener, OnSortClickListener, MobileFragmentPresenterInterface {

    @Inject
    lateinit var presenter: MobileFragmentPresenter
    private var mobileAdapter = MobileAdapter(this)
    private lateinit var recyclerViewMobile: RecyclerView
    private lateinit var mobileList: List<MobileModel>
    @Inject
    lateinit var logString: LogString


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mobile, container, false)
    }

    override fun showToast(message: String) {
        context?.showToast(message)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val roomDatabase = getRoomDatabase()
        logString.showLog()

        presenter.init(roomDatabase)
        setRecyclerView(view)
        swipe_toRefresh.setOnRefreshListener {
            presenter.loadMobile()
        }
    }

    override fun loadMobileList(mobileList: List<MobileModel>) {
        this.mobileList = mobileList
        runUiThread()
        swipeToDeleteStop()
    }

    private fun getRoomDatabase(): AppDatbase? {
        context?.let { it ->
            return AppDatbase.getInstance(it).also { database ->
                database.openHelper.readableDatabase
            }
        } ?: run {
            return null
        }
    }

    override fun onDataChange() {
        presenter.loadMobile()
    }

    private fun setRecyclerView(view: View) {
        recyclerViewMobile = view.findViewById(R.id.recyclerView)
        recyclerViewMobile.let {
            it.adapter = mobileAdapter
            it.layoutManager = LinearLayoutManager(context)
            it.itemAnimator = DefaultItemAnimator()
        }
    }

    private fun runUiThread() {
        //because of Only the original thread that created a view hierarchy can touch its views
        activity?.runOnUiThread { setMobileAdapter(mobileList) }
    }

    private fun swipeToDeleteStop() {
        swipe_toRefresh.isRefreshing = false
    }

    override fun sortPriceLowToHeight() {
        setMobileAdapter(mobileList.sortedBy { it.price })
    }

    override fun sortPriceHighToLow() {
        setMobileAdapter(mobileList.sortedByDescending { it.price })
    }

    override fun sortRatingFromHighToLow() {
        setMobileAdapter(mobileList.sortedByDescending { it.rating })
    }

    override fun onHeartClick(mobile: MobileModel) {
        presenter.setHeartClick(mobile)
        setMobileAdapter(mobileList)
    }


    override fun onMobileClick(mobile: MobileModel, _view: View) {
        var intent = Intent(context, MobileDetailActivity::class.java).putExtra("mobile", mobile)
        context!!.startActivity(intent)
    }

    private fun setMobileAdapter(list: List<MobileModel>) {
        mobileList = list
        mobileAdapter.submitList(mobileList)
    }
}

interface MobileFragmentPresenterInterface {
    fun loadMobileList(mobileList: List<MobileModel>)
    fun showToast(message: String)
}






