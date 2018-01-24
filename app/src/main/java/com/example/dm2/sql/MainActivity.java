package com.example.dm2.sql;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);

        ArrayList<Persona> personas = new ArrayList<Persona>();
        AgendaSQLiteHelper agendaDB = new AgendaSQLiteHelper(this,"agendadb",null,2);
        SQLiteDatabase db = agendaDB.getReadableDatabase();

        if (db != null){
            Cursor c = db.rawQuery("SELECT nombre, apellido, telefono FROM agenda",null);

            if (c.moveToNext()){
                do{
                    personas.add(new Persona(c.getString(0),c.getString(1),c.getString(2)));
                } while (c.moveToNext());
            }
            db.close();
        }
        /////////////////////
        Log.d("BD","Longitud Arraylist: "+personas.size());

        Persona[] datos = new Persona[personas.size()];
        int i=0;
        for (Persona p: personas) {
            datos[i++] = p;
        }
        AgendaAdapter agenda = new AgendaAdapter(this,datos);
        list.setAdapter(agenda);
    }
}

