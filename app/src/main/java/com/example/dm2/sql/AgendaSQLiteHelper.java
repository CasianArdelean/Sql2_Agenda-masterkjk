package com.example.dm2.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dm2 on 17/01/2018.
 */

public class AgendaSQLiteHelper extends SQLiteOpenHelper {
    String sql = "CREATE TABLE agenda (" +
            "id INTEGER PRIMARY KEY," +
            "nombre TEXT," +
            "apellido TEXT," +
            "telefono TEXT" +
            ")";

    //constructor del padre
    public AgendaSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
        addLines(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS agenda");
        onCreate(sqLiteDatabase);
    }


    private void addLines(SQLiteDatabase db) {
        Persona[] personas ={
                new Persona("Jon","Zantos","123456789"),
                new Persona("Casian","Ardelean","123456789"),
                new Persona("Max","Power","123456789"),
                new Persona("Homero","Simpson","123456789")
        };

        ContentValues content = null;
        for (int i = 0; i < personas.length ; i++) {
            content = new ContentValues();
            content.put("id",(i+1));
            content.put("nombre",personas[i].getNombre());
            content.put("apellido",personas[i].getApellido());
            content.put("telefono",personas[i].getTelefono());

            db.insert("agenda",null,content);
        }
    }
}
