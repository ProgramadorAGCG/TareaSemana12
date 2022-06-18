package com.ucs.sistemas.appsesion11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.ucs.sistemas.appsesion11.adaptor.AdaptadorUsuario;
import com.ucs.sistemas.appsesion11.dao.UsuriousDAOImpl;
import com.ucs.sistemas.appsesion11.entidad.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
Button btnNuevom;
ListView lstUsuariosm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNuevom=(Button)findViewById(R.id.btnNuevo);
        lstUsuariosm=(ListView)findViewById(R.id.lstUsuarios);
        lstUsuariosm.setOnItemClickListener(this);
        btnNuevom.setOnClickListener(this);
        cargar();
    }

    private void cargar() {
        //crear un objeto de la clase UsuarioDAOImpl
        UsuriousDAOImpl dao=new UsuriousDAOImpl(this);
       ArrayList<Usuario> lista= dao.listaUsuario();
        AdaptadorUsuario adaptador=new AdaptadorUsuario(lista,this);
        lstUsuariosm.setAdapter(adaptador);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,NuevoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Usuario bean=(Usuario)lstUsuariosm.getItemAtPosition(position);
        Intent intent=new Intent(this,datosActivity.class);
        intent.putExtra("m",bean);
        startActivity(intent);
    }



}













