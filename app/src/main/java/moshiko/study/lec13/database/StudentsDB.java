package moshiko.study.lec13.database;


//Class to initially create the data base - create the TABLES


//USED ONCE -> to create tables


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

//used all the time -> to get the db object
public class StudentsDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "StudentDb";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Students";

    public static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME +"(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + " name TEXT NOT NULL,"
            + "email TEXT)";

    public StudentsDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);//ResultSet Factory
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //destroy table
        db.execSQL("DROP TABLE Students");

        //crate table
        onCreate(db);
    }
}
