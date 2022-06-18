package com.ucs.sistemas.appsesion11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ucs.sistemas.appsesion11.dao.UsuriousDAOImpl;
import com.ucs.sistemas.appsesion11.entidad.Usuario;

public class NuevoActivity extends AppCompatActivity implements View.OnClickListener {
        EditText edtusuarion,edtpasswordn;
        Button btnregresarn,btnregistrarn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        edtusuarion=(EditText)findViewById(R.id.edtusuarion) ;
        edtpasswordn=(EditText)findViewById(R.id.edtpasswordn);
        btnregistrarn=(Button)findViewById(R.id.btnregistrarn);
        btnregistrarn.setOnClickListener(this);
        btnregresarn=(Button)findViewById(R.id.btnregresarn);
        btnregresarn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        UsuriousDAOImpl dao=new UsuriousDAOImpl(this);
        if(v==btnregistrarn){
            Usuario bean=new Usuario();
            bean.setUsuario(edtusuarion.getText().toString());
            bean.setPassword(edtpasswordn.getText().toString());
            dao.inserta(bean);
            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
        }
        if(v==btnregresarn){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }
}