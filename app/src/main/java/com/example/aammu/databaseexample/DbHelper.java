package com.example.aammu.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context,"MyDatabase",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE myTable (" +
                "personName TEXT, " +
                "personPassword TEXT,  "+
                "personEmail Text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void storePerson(Person person){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("personName",person.getPersonName());
        contentValues.put("personPassword",person.getPersonContact());
        contentValues.put("personEmail",person.getPersonEmail());
        db.insert("myTable",null,contentValues);



    }

    public boolean getPerson(Person person){
        SQLiteDatabase db = getReadableDatabase();
        String query ="SELECT * FROM myTable";
        Cursor cursor=db.rawQuery(query,null);
        while(cursor.moveToNext()){
            String name=cursor.
                    getString(cursor.
                            getColumnIndex("personName"));
            String password = cursor.
                    getString(cursor.
                            getColumnIndex("personPassword"));
            if(name.equals(person.getPersonName())
                    &&
                    password.equals(person.getPersonContact())){
                return true;
            }
        }
        return false;

    }




}
