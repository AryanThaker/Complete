package com.example.complete

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(var context: Context): SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    companion object {
        private var DB_NAME = "signup"
        private var DB_TABEL = "sup"
        private var DB_VERSION = 1
        private var DB_NAMEE = "name"
        private var DB_USERNAME = "username"
        private var DB_PASSWORD = "password"
        private var DB_EMAIL = "email"
        private var DB_MOBILENUBMER = "number"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "CREATE TABLE $DB_TABEL ($DB_NAMEE  TEXT" +
                ",$DB_USERNAME TEXT,$DB_PASSWORD PASSWORD,$DB_EMAIL EMAIL,$DB_MOBILENUBMER LONG)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query = "DROP TABLE $DB_TABEL IF EXISTS"
        p0?.execSQL(query)
        onCreate(p0)

    }

    fun retriveall(): ArrayList<register> {
        var db = readableDatabase
        var cursor = db.query(DB_TABEL, null, null, null, null, null, null)
        var arr: ArrayList<register> = ArrayList()
        while (cursor.moveToNext()) {

            var username = cursor.getString(1)
            var password = cursor.getString(2)


            var emp = register(username, password)
            arr.add(emp)


        }
        return arr

    }

        fun insert(emp: register): Boolean {
            var db = writableDatabase
            var cv = ContentValues()
            cv.put(DB_NAMEE, emp.name)
            cv.put(DB_USERNAME, emp.username)
            cv.put(DB_PASSWORD, emp.password)
            cv.put(DB_EMAIL, emp.email)
            cv.put(DB_MOBILENUBMER, emp.number)
            var flag = db.insert(DB_TABEL, null, cv)
            if (flag > 0) {
                return true
            } else {
                return false
            }
        }
    }
