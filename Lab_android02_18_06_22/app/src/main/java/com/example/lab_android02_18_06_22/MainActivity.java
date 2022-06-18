package com.example.lab_android02_18_06_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.lab_android02_18_06_22.adaptador.AdaptadorDocente;
import com.example.lab_android02_18_06_22.dao.DocenteDAOImpl;
import com.example.lab_android02_18_06_22.entidad.Docente;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    Button btnNuevo;
    ListView lstDocentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNuevo=findViewById(R.id.btnNuevo);
        lstDocentes=findViewById(R.id.lstDocentes);

        btnNuevo.setOnClickListener(this);
        lstDocentes.setOnItemClickListener(this);

        cargar();
    }
    void cargar(){
        DocenteDAOImpl dao=new DocenteDAOImpl(this);
        ArrayList<Docente> lista=dao.listaDocentes();
        //adaptador
        AdaptadorDocente adaptador=new AdaptadorDocente(lista,this);
        //mostrar el adaptador en el ListView
        lstDocentes.setAdapter(adaptador);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, NuevoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //obtener el Docente segùn lo seleccionado en el ListView
        Docente bean= (Docente) lstDocentes.getItemAtPosition(position);
        Intent intent=new Intent(this,datosActivity.class);
        intent.putExtra("docente",bean); //este error es porque la clase docente
        //debe ser serializada
        startActivity(intent);
    }
}