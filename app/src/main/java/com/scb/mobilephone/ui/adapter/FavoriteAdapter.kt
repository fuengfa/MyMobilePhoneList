package com.scb.mobilephone.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.scb.mobilephone.ui.callback.CustomItemTouchHelperListener
import com.scb.mobilephone.R
import com.scb.mobilephone.ui.model.*

class FavoriteAdapter(private val deleteListener: DeleteFavorite) :
    RecyclerView.Adapter<FavViewHolder>(), CustomItemTouchHelperListener {

    private var _mobiles: List<MobileModel> = listOf()

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        return false
    }

    override fun onItemDismiss(position: Int) {
        deleteListener.onDeleteFavorite(_mobiles[position].id)
        deleteListener.submitDataChange()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavViewHolder(parent)

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        holder.bind(_mobiles[position], deleteListener)
    }

    override fun getItemCount(): Int {
        return _mobiles.size
    }

    fun submitList(list: List<MobileModel>){
        _mobiles = list
        notifyDataSetChanged()
    }
}

class FavViewHolder (parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(
            R.layout.favorite_list,
            parent, false)
) {
    private var mobilePic: ImageView ?=null
    private var mobileName: TextView ?=null
    private var mobilePrice: TextView ?=null
    private var mobileRating: TextView ?=null

    fun bind(mobile: MobileModel, delete: DeleteFavorite) {

        mobilePic= itemView.findViewById(R.id.faveImage) as ImageView
        mobileName = itemView.findViewById(R.id.favName) as TextView
        mobilePrice = itemView.findViewById(R.id.favPrice) as TextView
        mobileRating = itemView.findViewById(R.id.faveRating) as TextView
            mobilePic?.let {
                Glide
                    .with(itemView.context)
                    .load(mobile.thumbImageURL)
                    .centerCrop()
                    .into(it)
            }
            mobileName?.text = mobile.name
            mobilePrice?.text = mobile.price.toString()
            mobileRating?.text = "Rating: ${mobile.rating}"
            itemView.setOnClickListener{
            delete.showDetail(mobile, itemView)
        }
    }

}

interface DeleteFavorite{
    fun onDeleteFavorite(id: Int)
    fun submitDataChange()
    fun showDetail(mobile: MobileModel, _view: View)
}

