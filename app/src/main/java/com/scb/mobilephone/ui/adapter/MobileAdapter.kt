package com.scb.mobilephone.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.scb.mobilephone.ui.model.MobileModel
import com.scb.mobilephone.R

class MobileAdapter(private val listener: OnMobileClickListener)
    : RecyclerView.Adapter<MobileViewHolder>(){

    private val mobiles: List<MobileModel>
        get() = _mobiles

    private var _mobiles: List<MobileModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MobileViewHolder(parent)

    override fun onBindViewHolder(holder: MobileViewHolder, position: Int) {

        holder.bind(_mobiles[position], listener)
    }

    override fun getItemCount(): Int {
        return mobiles.size
    }

    fun submitList(list: List<MobileModel>) {
        _mobiles = list
        notifyDataSetChanged()
    }

}


class MobileViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(
            R.layout.mobilephone,
            parent, false)
) {
    private var mobileDescription: TextView? = null
    private var mobileRating: TextView? = null
    private var mobileHaert: ImageView? = null
    private var mobilePrice: TextView? = null
    private var mobilePic: ImageView? = null
    private var mobileName: TextView? = null


    fun bind(mobile: MobileModel, listener: OnMobileClickListener) {

        mobileDescription = itemView.findViewById(R.id.mobileDescription) as TextView
        mobilePic = itemView.findViewById(R.id.mobilePicture) as ImageView
        mobileName = itemView.findViewById(R.id.mobileModel) as TextView
        mobilePrice = itemView.findViewById(R.id.mobilePrice) as TextView
        mobileRating = itemView.findViewById(R.id.mobileRating) as TextView
        mobileHaert = itemView.findViewById(R.id.mobileHeart) as ImageView

        mobilePic?.let {
            Glide
                .with(itemView.context)
                .load(mobile.thumbImageURL)
                .centerCrop()
                .into(it)
        }

        mobileName?.text = mobile.name
        mobileDescription?.text = mobile.description
        mobilePrice?.text = "Price: ${mobile.price}"
        mobileRating?.text = "Rating: ${mobile.rating}"

        if(mobile.fav == 0 ){
            mobileHaert?.setImageResource(R.drawable.ic_favorite)
        }else{
            mobileHaert?.setImageResource(R.drawable.ic_favorite_black_24dp)
        }

        itemView.setOnClickListener {
            listener.onMobileClick(mobile,itemView)
        }

        mobileHaert?.setOnClickListener {
            if(mobile.fav == 0){
                mobile.fav = 1
            }else{
                mobile.fav = 0
            }
            Log.d("plistfromMadap", mobile.toString())
            listener.onHeartClick(mobile) }
    }
}

interface OnMobileClickListener {
    fun onMobileClick(mobile: MobileModel, view: View)
    fun onHeartClick(mobile : MobileModel)
    fun onDataChange()
}



