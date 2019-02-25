package com.example.shakil.kotlinrclgroupname.Adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.amulyakhare.textdrawable.TextDrawable
import com.example.shakil.kotlinrclgroupname.Common.Common
import com.example.shakil.kotlinrclgroupname.Interface.IOnAlphabetItemClickListener
import com.example.shakil.kotlinrclgroupname.R

class AlphabetAdapter : RecyclerView.Adapter<AlphabetAdapter.MyViewHolder>() {

    internal var alphabetList: List<String>
    internal lateinit var iOnAlphabetItemClick: IOnAlphabetItemClickListener

    init {
        alphabetList = Common.genAlphabetList()
    }

    fun setAlphabetClick(iOnAlphabetClickListener: IOnAlphabetItemClickListener) {
        iOnAlphabetItemClick = iOnAlphabetClickListener
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AlphabetAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.alphabet_item, p0, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return alphabetList.size
    }

    override fun onBindViewHolder(p0: AlphabetAdapter.MyViewHolder, p1: Int) {
        val drawable: TextDrawable
        //Get available position of character
        val available_position = Common.alphabet_available.indexOf(alphabetList[p1])

        //If character is available in list
        if (available_position != -1) {
            drawable = TextDrawable.builder().buildRound(alphabetList[p1], Color.GREEN)
        } else {
            //If character is not in alphabet , just set GRAY
            drawable = TextDrawable.builder().buildRound(alphabetList[p1], Color.GRAY)
        }

        p0.alphabet_item.setImageDrawable(drawable)
        p0.itemView.setOnClickListener {
            // When user choose alphabet character, just go back MainActivity and scroll to position of first character
            iOnAlphabetItemClick.onAlphabetItemClick(alphabetList[p1], available_position)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var alphabet_item: ImageView
        init {
            alphabet_item = itemView.findViewById(R.id.alphabet_item) as ImageView
        }
    }
}