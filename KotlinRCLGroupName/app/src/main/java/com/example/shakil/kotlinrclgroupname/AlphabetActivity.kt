package com.example.shakil.kotlinrclgroupname

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.shakil.kotlinrclgroupname.Adapter.AlphabetAdapter
import com.example.shakil.kotlinrclgroupname.Interface.IOnAlphabetItemClickListener
import kotlinx.android.synthetic.main.activity_alphabet.*

class AlphabetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet)

        val alphabetAdapter = AlphabetAdapter()

        alphabetAdapter.setAlphabetClick(object : IOnAlphabetItemClickListener {
            override fun onAlphabetItemClick(value: String, position: Int) {
                if (position != -1) {
                    val returnIntent = Intent()
                    returnIntent.putExtra("result", value)
                    setResult(Activity.RESULT_OK, returnIntent)
                    finish()
                }
            }
        })

        recycler_alphabet.layoutManager = GridLayoutManager(this, 4)
        recycler_alphabet.adapter = alphabetAdapter
    }
}
