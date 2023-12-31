package com.example.splashscreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public  static  final String dbName="Login.db";

    public DbHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(username TEXT primary key , password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists users");

    }

    public  Boolean insertData(String userName,String password){
        SQLiteDatabase myDB= this.getWritableDatabase();
        ContentValues content= new ContentValues();
        content.put("username",userName);
        content.put("password",password);
        long results= myDB.insert("users" ,null,content);
        if(results==-1)return  false;
        else
            return true;
    }

    public Boolean checkUserName(String userName){
        SQLiteDatabase myDB= this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("Select * from users where username=?",new String[] {userName});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkUserPassword(String username,String password){
        SQLiteDatabase myDB= this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("Select * from users where username=? and password=?",new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
