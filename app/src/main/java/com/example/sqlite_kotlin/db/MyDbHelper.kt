package com.example.sqlite_kotlin.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLDataException
import java.sql.SQLException
//Создаем базу и таблицу в ней
class MyDbHelper (context: Context) : SQLiteOpenHelper(context, MyDbNameClass.DATABASE_NAME,
        null, MyDbNameClass.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDbNameClass.CREAT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(MyDbNameClass.SQL_DELETE_TABLE)
        onCreate(db)

    }
}