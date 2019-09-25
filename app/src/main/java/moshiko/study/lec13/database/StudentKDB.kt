package moshiko.study.lec13.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class StudentKDB(context:Context): SQLiteOpenHelper(context,
    DB_NAME, null,
    DB_VERSION
) {


    //static in java ->
    companion object{
        val DB_VERSION = 1;
        val DB_NAME = "StudentDB"
        val TABLE_NAME = "Students";

        //multy line strings:
        val CRATE_TABLE_STUDENT = """
            CREATE TABLE $TABLE_NAME(_id INTEGER PRIMARY KEY AUTOINCREMENT,
                                                     name TEXT NOT NULL,
                                                     email TEXT)
                                                     """
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CRATE_TABLE_STUDENT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE Students")

        onCreate(db)

    }




}