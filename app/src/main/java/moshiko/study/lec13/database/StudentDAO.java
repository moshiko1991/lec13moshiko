package moshiko.study.lec13.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import moshiko.study.lec13.Models.Student;
import moshiko.study.lec13.Models.StudentK;
import moshiko.study.lec13.controllers.MainActivity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//CRUD -> CREATE READ UPDATE DELETE
public class StudentDAO{


    //Properties:
    private SQLiteDatabase db;

    //private ctor
    private StudentDAO(SQLiteDatabase db){
        this.db = db;
    }

    private static StudentDAO instance = null;

    public static StudentDAO getInstance(Context c){
        //singleton:
        if (instance == null){
            StudentsDB sdb = new StudentsDB(c);
            SQLiteDatabase db = sdb.getWritableDatabase();

            instance = new StudentDAO(db);
        }
        return instance;
    }

    public long addStudent(StudentK s) {
        ContentValues cv = new ContentValues();
        cv.put("name", s.getName());
        cv.put("email", s.getEmail());

        int id = (int) db.insert(StudentsDB.TABLE_NAME, null, cv);
        s.setId(id);

        return id;
    }

    //TODO: //void update

    public boolean updateStudent(StudentK s){
        String whereClause = "_id = ?";
        ContentValues cv = from(s);
       return db.update(StudentsDB.TABLE_NAME, cv, whereClause, new String[]{s.getId() + ""}) > 0;

    }

    //add comment
    public boolean deleteStudent(StudentK s){
        return db.delete(StudentsDB.TABLE_NAME, "_id = ?", new String[]{"" + s.getId()}
        ) > 0;
    }

    public ContentValues from(StudentK s){
        ContentValues cv = new ContentValues();
        cv.put("name", s.getName());
        cv.put("email", s.getEmail());
        return cv;
    }


    public List<StudentK> getStudents(){
        //new list
        List<StudentK> students = new ArrayList<>();

        String[] projection = {"_id", "name", "email"};

//        String selection = "name LIKE ? AND email LIKE ?";
//
//        String[] selectionArgs = {"m%", "%@%"};

        String selection = "_id > ?";
        String[] selectionArgs = {"10; DROP TABLE students"};

        //query -> fills the list
       Cursor cursor = db.query(StudentsDB.TABLE_NAME,
               projection,
               null,
               null,
               null,
               null,
               "name ASC");

       if (!cursor.moveToFirst()){
           return students;

       }

       do {
           int id = cursor.getInt(0);
           String name = cursor.getString(1);
           String email = cursor.getString(2);

           students.add(new StudentK (name, email, id));
       }while (cursor.moveToNext());

       cursor.close();

        //return list

        return students;
    }


}
