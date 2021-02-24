package com.example.sqlite_kotlin.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.icu.text.CaseMap

class MyDbManager (val context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){                          //Открываем базу данных
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title: String, content: String, uri: String){   //Записать в базу данных
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE,title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT,content)
            put(MyDbNameClass.COLUMN_NAME_IMAGE_URL,uri)
        }
        db?.insert(MyDbNameClass.TABLE_NAME,null,values)
    }
    fun readDbData(): ArrayList<String>{                 //Считать с базы данных
        val dataList = ArrayList<String>()                 // это то что мы считываем
        val cursor = db?.query(MyDbNameClass.TABLE_NAME,null,null,null,null,null,null)

        with(cursor){
            while(this?.moveToNext()!!){
                val dataText = cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
                dataList.add(dataText.toString())

            }
        }
        cursor?.close()
        return dataList
    }
    fun closeDb(){
        myDbHelper.close()
    }
}