package moshiko.study.lec13.controllers

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import moshiko.study.lec13.Models.StudentK
import moshiko.study.lec13.R
import moshiko.study.lec13.database.StudentDAO
import moshiko.study.lec13.database.StudentKDB

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //INSERT:
        val dao:StudentDAO = StudentDAO.getInstance(this)

        StudentDAO.getInstance(this).addStudent(StudentK("Dave",
            "Dave@gmail.com",
            null)
        )


        dao.updateStudent(StudentK("Moshiko","Moshiko@gmail.com", 1))

        //GET:
        println(dao.students)
    }

    //get:


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
