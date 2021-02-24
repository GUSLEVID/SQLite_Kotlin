package com.example.sqlite_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlite_kotlin.db.MyAdapter
import com.example.sqlite_kotlin.db.MyDbManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)
    val myAdapter = MyAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    override fun onResume() {

        super.onResume()
        myDbManager.openDb()
        fillAdapter()
    }

    fun onClickNew(view: View) {
        val i = Intent(this,EditActivity::class.java)
        startActivity(i)

        }
    fun init(){

        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = myAdapter
    }
    fun fillAdapter(){
        myAdapter.updateAdapter(myDbManager.readDbData() )
    }

}