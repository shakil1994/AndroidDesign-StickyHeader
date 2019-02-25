package com.example.shakil.kotlinrclgroupname.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.example.shakil.kotlinrclgroupname.AlphabetActivity
import com.example.shakil.kotlinrclgroupname.Common.Common
import com.example.shakil.kotlinrclgroupname.Model.Person
import com.example.shakil.kotlinrclgroupname.R

class PersonAdapter(internal var context: Context, internal var personList: List<Person>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    internal inner class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_group_title: TextView

        init {
            txt_group_title = itemView.findViewById(R.id.txt_group_title) as TextView
        }
    }

    internal inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_person_name: TextView
        var txt_person_position: TextView
        var person_avatar: ImageView

        init {
            txt_person_name = itemView.findViewById(R.id.txt_person_name) as TextView
            txt_person_position = itemView.findViewById(R.id.txt_person_position) as TextView

            person_avatar = itemView.findViewById(R.id.person_avatar) as ImageView
        }
    }

    override fun getItemViewType(position: Int): Int {
        return personList.get(position).viewType
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        when (viewType) {
            Common.VIEWTYPE_GROUP -> {
                val group = inflater.inflate(R.layout.group_layout, viewGroup, false) as ViewGroup
                return GroupViewHolder(group)
            }

            Common.VIEWTYPE_PERSON -> {
                val personLayout = inflater.inflate(R.layout.person_layout, viewGroup, false) as ViewGroup
                return PersonViewHolder(personLayout)
            }
            else -> {
                val group = inflater.inflate(R.layout.group_layout, viewGroup, false) as ViewGroup
                return GroupViewHolder(group)
            }
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (viewHolder is GroupViewHolder) {
            viewHolder.txt_group_title.text = personList[position].name
            viewHolder.itemView.setOnClickListener {
                //Start activity to display all alphabet character to choose
                (context as Activity).startActivityForResult(
                    Intent(context, AlphabetActivity::class.java),
                    Common.REQUEST_CODE
                )
            }
        } else if (viewHolder is PersonViewHolder) {
            viewHolder.txt_person_name.text = personList[position].name
            viewHolder.txt_person_position.text = personList[position].position

            //Set Avatar
            val generator = ColorGenerator.MATERIAL
            val drawable = TextDrawable.builder().buildRound(

                personList[position].name!![0].toString(), generator.randomColor
            )

            viewHolder.person_avatar.setImageDrawable(drawable)

            viewHolder.itemView.setOnClickListener {
                Toast.makeText(context, "" + personList[position].name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}