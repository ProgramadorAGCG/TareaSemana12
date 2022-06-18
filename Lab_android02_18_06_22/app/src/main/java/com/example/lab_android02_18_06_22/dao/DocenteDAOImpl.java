package com.example.lab_android02_18_06_22.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab_android02_18_06_22.data.SqlOpenHelper;
import com.example.lab_android02_18_06_22.entidad.Docente;

import java.util.ArrayList;

public class DocenteDAOImpl {

    SqlOpenHelper admin;
    public DocenteDAOImpl(Context contexto){
        admin=new SqlOpenHelper(contexto, "consorcio.db", null, 1);
    }

    //mètodo que retorna una lista de docentes
    public ArrayList<Docente> listaDocentes(){
        ArrayList<Docente> data=new ArrayList<Docente>();
        Docente bean=null;

        SQLiteDatabase base=admin.getReadableDatabase();

        Cursor cursor=base.rawQuery("select * from tb_docente",null);
        while (cursor.moveToNext()){ //cursor es como rs y movetoNext como next rs.next de java
            bean=new Docente(); //creo objeto bean de la clase Docente
            bean.setCodigo(cursor.getInt(0));//en sqlite la columna empieza de 0 en este caso tu tabla el cod primer campo es int
            bean.setNombres(cursor.getString(1)); //asignar valor a los atributo objeto bean con la fila actual
            bean.setPaterno(cursor.getString(2));
            bean.setMaterno(cursor.getString(3));
            bean.setSexo(cursor.getString(4));
            bean.setHijos(cursor.getInt(5));
            bean.setSueldo(cursor.getDouble(6));
            data.add(bean); //enviar la lista
        }
        return  data;
    }

    //registrar
    public int registrarDocente(Docente bean){
        int salida=-1;
        //abrir acceso a la bd en modo escritura
        SQLiteDatabase base=admin.getWritableDatabase();
        //Crear objeto de la clase ContentValues, dicha clase trabajaa con claves y valores
        ContentValues contentValues=new ContentValues();
        //claves son nombres de los campos de la tabla
        //values son atributos del objeto bean
        contentValues.put("nom",bean.getNombres());
        contentValues.put("pat",bean.getPaterno());
        contentValues.put("mat",bean.getMaterno());
        contentValues.put("sexo",bean.getSexo());
        contentValues.put("hijos",bean.getHijos());
        contentValues.put("sueldo",bean.getSueldo());
        //llamar al mètodo insert
        salida=(int)base.insert("tb_docente","cod",contentValues);
        return salida;
    }

    //actualizar
    public int actualizarDocente(Docente bean){
        int salida=-1;
        //abrir acceso a la bd en modo escritura
        SQLiteDatabase base=admin.getWritableDatabase();
        //Crear objeto de la clase ContentValues, dicha clase trabajaa con claves y valores
        ContentValues contentValues=new ContentValues();
        //claves son nombres de los campos de la tabla
        //values son atributos del objeto bean
        contentValues.put("cod",bean.getCodigo());
        contentValues.put("nom",bean.getNombres());
        contentValues.put("pat",bean.getPaterno());
        contentValues.put("mat",bean.getMaterno());
        contentValues.put("sexo",bean.getSexo());
        contentValues.put("hijos",bean.getHijos());
        contentValues.put("sueldo",bean.getSueldo());
        //llamar al mètodo insert
        salida=base.update("tb_docente",contentValues,"cod="+bean.getCodigo(),null);
        return salida;
    }

    //eliminar
    public int eliminarDocente(int codigo) {
        int salida = -1;
        //abrir acceso a la bd en modo escritura
        SQLiteDatabase base = admin.getWritableDatabase();
        salida=base.delete("tb_docente","cod="+codigo,null);

        return salida;
    }

}
