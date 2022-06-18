package com.ucs.sistemas.appsesion11.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ucs.sistemas.appsesion11.data.SqlOpenHelper;


import com.ucs.sistemas.appsesion11.entidad.Usuario;

import java.util.ArrayList;

public class UsuriousDAOImpl {
    //delclarar variable de tipo SqlOpenHelper
    SqlOpenHelper admin;
    //Generar constructor de la clase UsuarioDAOImpl

    public UsuriousDAOImpl(Context contexto) {
       //crear objeto admin
        admin=new SqlOpenHelper(contexto,"dbuser", null ,1);
    }
    //.............métodos para el crud...........
    public ArrayList<Usuario> listaUsuario(){
        ArrayList<Usuario> data=new ArrayList<Usuario>();
        Usuario bean=null;
        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery("select * from usuario",null);
        while (cursor.moveToNext()){
          bean=new Usuario();
          bean.setId(cursor.getInt(0));
          bean.setUsuario(cursor.getString(1));
          bean.setPassword(cursor.getString(2));
          data.add(bean);
        }
        return  data;
    }
    //método para insertar,actualizar, eliminar
    public int inserta(Usuario bean){
        int salida=-1;
        //abrir acceso a la base de datos en modo escritura
        SQLiteDatabase base=admin.getWritableDatabase();
        //Crear un objeto de la clase ContentValues
        ContentValues contentValues=new ContentValues();
        contentValues.put("usuario",bean.getUsuario());
        contentValues.put("clave",bean.getPassword());
        //llamar al método inserta
        salida=(int) base.insert("usuario","id",contentValues);
        return salida;
    }
    public int actualizar(Usuario bean){
        int salida=-1;
        //abrir acceso a la base de datos en modo escritura
        SQLiteDatabase base=admin.getWritableDatabase();
        //Crear un objeto de la clase ContentValues
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",bean.getId());
        contentValues.put("usuario",bean.getUsuario());
        contentValues.put("clave",bean.getPassword());
        //llamar al método actualiza
        salida=(int) base.update("usuario",contentValues,"id="+bean.getId(),null);
        return salida;
    }
    public int eliminar(int codigo){
        int salida=-1;
        //abrir acceso a la base de datos en modo escritura
        SQLiteDatabase base=admin.getWritableDatabase();
         //llamar al método actualiza
        salida=(int) base.delete("usuario","id="+codigo,null);
        return salida;
    }


}
