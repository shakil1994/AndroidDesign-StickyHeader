package com.example.shakil.kotlinrclgroupname.Common

import android.content.Context
import android.graphics.PointF
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSmoothScroller
import android.support.v7.widget.RecyclerView

class LinearLayoutManagerWithSmoothScroller : LinearLayoutManager {

    constructor(context: Context): super(context, LinearLayoutManager.VERTICAL, false)

    constructor(context: Context, orientation: Int, reverseLayout: Boolean): super(context, orientation, reverseLayout)

    override fun smoothScrollToPosition(recyclerView: RecyclerView?, state: RecyclerView.State?, position: Int) {
        val smoothScroller = TopSnappedSmoothScroller(recyclerView!!.context)
        smoothScroller.targetPosition = position
        startSmoothScroll(smoothScroller)
    }

    inner class TopSnappedSmoothScroller(context: Context) : LinearSmoothScroller(context) {

        override fun getVerticalSnapPreference(): Int {
            return SNAP_TO_START
        }

        override fun computeScrollVectorForPosition(targetPosition: Int): PointF? {
            return this@LinearLayoutManagerWithSmoothScroller.computeScrollVectorForPosition(targetPosition)

        }
    }

}