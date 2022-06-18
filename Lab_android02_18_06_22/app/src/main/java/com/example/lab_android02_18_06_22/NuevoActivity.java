package com.example.lab_android02_18_06_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lab_android02_18_06_22.dao.DocenteDAOImpl;
import com.example.lab_android02_18_06_22.entidad.Docente;

public class NuevoActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtNombreN,edtPaternoN,edtMaternoN,edtSueldoN,edtHijosN;
    Spinner spnSexoN;
    Button btnRegistrar, btnRegresarN;
    //
    DocenteDAOImpl daoDocente=new DocenteDAOImpl(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        edtNombreN=(EditText) findViewById(R.id.edtNombreN);
        edtPaternoN=(EditText) findViewById(R.id.edtPaternoN);
        edtMaternoN=(EditText) findViewById(R.id.edtMaternoN);
        edtSueldoN=(EditText) findViewById(R.id.edtSueldoN);
        edtHijosN=(EditText) findViewById(R.id.edtHijosN);
        spnSexoN=(Spinner) findViewById(R.id.spnSexoN);
        btnRegistrar=(Button) findViewById(R.id.btnRegistrar);
        btnRegresarN=(Button) findViewById(R.id.btnRegresarN);
        btnRegistrar.setOnClickListener(this);
        btnRegresarN.setOnClickListener(this);
        //

    }

    @Override
    public void onClick(View v) {
        if(v==btnRegistrar){
            //Crear un objeto de la clase Docente y setear sus atributos con los controles
            Docente bean=new Docente();
            bean.setNombres(edtNombreN.getText().toString());
            bean.setPaterno(edtPaternoN.getText().toString());
            bean.setMaterno(edtMaternoN.getText().toString());
            bean.setSexo(spnSexoN.getSelectedItem().toString());
            bean.setHijos(Integer.parseInt(edtHijosN.getText().toString()));
            bean.setSueldo(Double.parseDouble(edtSueldoN.getText().toString()));
            daoDocente.registrarDocente(bean);
        }

        if(v==btnRegresarN){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }

}