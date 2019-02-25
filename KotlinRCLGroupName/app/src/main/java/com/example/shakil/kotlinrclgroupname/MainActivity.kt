package com.example.shakil.kotlinrclgroupname

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.shakil.kotlinrclgroupname.Adapter.PersonAdapter
import com.example.shakil.kotlinrclgroupname.Common.Common
import com.example.shakil.kotlinrclgroupname.Common.LinearLayoutManagerWithSmoothScroller
import com.example.shakil.kotlinrclgroupname.Model.Person
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    internal var personList = ArrayList<Person>()
    internal lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManagerWithSmoothScroller(this)
        recycler_person.layoutManager = layoutManager
        recycler_person.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))

        createPersonList()
        val adapter = PersonAdapter(this, personList)
        recycler_person.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Common.REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data!!.getStringExtra("result")
                val position = Common.findPositionWithName(result, personList)
                recycler_person.smoothScrollToPosition(position)
            }
        }
    }

    private fun createPersonList() {
        personList = Common.genPersonGroup()
        personList = Common.sortList(personList) //Sort
        personList = Common.addAlphabets(personList) //Add alphabet header
    }
}
