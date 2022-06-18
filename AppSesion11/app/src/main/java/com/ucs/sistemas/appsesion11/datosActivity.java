package com.ucs.sistemas.appsesion11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ucs.sistemas.appsesion11.dao.UsuriousDAOImpl;
import com.ucs.sistemas.appsesion11.entidad.Usuario;

public class datosActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnactualizard,btneliminard,btnregresard;
    TextView tvcodigod;
    EditText edtusuariod,edtpasswordd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        tvcodigod=(TextView)findViewById(R.id.tvcodigod);
        edtusuariod=(EditText)findViewById(R.id.edtusuariod);
        edtpasswordd=(EditText)findViewById(R.id.edtpaswordd);

        btnactualizard=(Button)findViewById(R.id.btnactualizard);
        btneliminard=(Button)findViewById(R.id.btnEliminard);
        btnregresard=(Button)findViewById(R.id.btnregresard);
        btnregresard.setOnClickListener(this);
        btnactualizard.setOnClickListener(this);
        btneliminard.setOnClickListener(this);
        cargar();
    }

    private void cargar() {
        Usuario us=(Usuario)getIntent().getSerializableExtra("m");
        tvcodigod.setText(""+us.getId());
        edtusuariod.setText(us.getUsuario());
        edtpasswordd.setText(us.getPassword());

    }

    @Override
    public void onClick(View v) {
        UsuriousDAOImpl dao=new UsuriousDAOImpl(this);
        if(v==btneliminard){
            int codigo;
            codigo=Integer.parseInt(tvcodigod.getText().toString());
            dao.eliminar(codigo);
        }
        if(v==btnactualizard){
            Usuario bean=new Usuario();
            bean.setId(Integer.parseInt(tvcodigod.getText().toString()));
            bean.setUsuario(edtusuariod.getText().toString());
            bean.setPassword(edtpasswordd.getText().toString());
            dao.actualizar(bean);
        }

        if (v==btnregresard){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }
}