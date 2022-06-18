package com.ucs.sistemas.appsesion11.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;



public class SqlOpenHelper extends SQLiteOpenHelper {


    public SqlOpenHelper( Context context,  String name,  CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "usuario TEXT, "+
                "clave TEXT)");

        db.execSQL("CREATE TABLE movimientos(" +
                "idmovimiento INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fecha DATETIME DEFAULT CURRENT_TIMESTAMP,"+
                "descripcion TEXT," +
                "monto float," +
                "movimiento int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
