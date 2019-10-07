package com.scb.mobilephone.ui.callback

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class CustomItemTouchHelperCallback(private var listener: CustomItemTouchHelperListener) : ItemTouchHelper.Callback() {
    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        val dragFlags = 0
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        if (viewHolder?.itemViewType != target?.itemViewType) {
            return false
        }
        if (viewHolder != null && target != null) {
            return listener.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        }
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        listener.onItemDismiss(viewHolder.adapterPosition)
    }
}

interface CustomItemTouchHelperListener {
    fun onItemMove(fromPosition: Int, toPosition: Int) : Boolean

    fun onItemDismiss(position: Int)
}