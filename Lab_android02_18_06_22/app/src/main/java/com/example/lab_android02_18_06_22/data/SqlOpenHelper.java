package com.example.lab_android02_18_06_22.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlOpenHelper extends SQLiteOpenHelper {

    public SqlOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto,"consorcio.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_docente("+
                "cod integer primary key autoincrement,"+
                "nom varchar(25),"+
                "pat varchar(25),"+
                "mat varchar(25),"+
                "sexo varchar(15),"+
                "hijos int,"+
                "sueldo double)");
        db.execSQL("insert into tb_docente values(null,'Ana','Soto','Ayala','Femenino',2,1500)");
        db.execSQL("insert into tb_docente values(null,'Alicia','Rivera','Palacios','Femenino',1,2500)");
        db.execSQL("insert into tb_docente values(null,'Luis','Mora','Oca','Masculino',4,500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

}
