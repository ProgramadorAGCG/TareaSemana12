package com.example.lab_android02_18_06_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lab_android02_18_06_22.dao.DocenteDAOImpl;
import com.example.lab_android02_18_06_22.entidad.Docente;

public class datosActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvCodigo;
    EditText edtNombre,edtPaterno,edtMaterno,edtSueldo,edtHijos;
    Spinner spnSexo;
    Button btnActualizar,btnEliminar, btnRegresar;
    //
    DocenteDAOImpl daoDocente=new DocenteDAOImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        tvCodigo=(TextView) findViewById(R.id.tvCodigo);
        edtNombre=(EditText) findViewById(R.id.edtNombre);
        edtPaterno=(EditText) findViewById(R.id.edtPaterno);
        edtMaterno=(EditText) findViewById(R.id.edtMaterno);
        edtSueldo=(EditText) findViewById(R.id.edtSueldo);
        edtHijos=(EditText) findViewById(R.id.edtHijos);
        spnSexo=(Spinner) findViewById(R.id.spnSexo);
        btnActualizar=(Button) findViewById(R.id.btnActualizar);
        btnEliminar=(Button) findViewById(R.id.btnEliminar);
        btnRegresar=(Button) findViewById(R.id.btnRegresar);
        btnActualizar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
        //
        cargar();

    }

    public void onClick(View v) {
        if(v==btnActualizar){
            //Crear un objeto de la clase Docente y setear sus atributos con los controles
            Docente bean=new Docente();
            bean.setCodigo(Integer.parseInt(tvCodigo.getText().toString()));
            bean.setNombres(edtNombre.getText().toString());
            bean.setPaterno(edtPaterno.getText().toString());
            bean.setMaterno(edtMaterno.getText().toString());
            bean.setSexo(spnSexo.getSelectedItem().toString());
            bean.setHijos(Integer.parseInt(edtHijos.getText().toString()));
            bean.setSueldo(Double.parseDouble(edtSueldo.getText().toString()));
            daoDocente.actualizarDocente(bean);
        }
        if(v==btnEliminar){
            //leer codigo
            int cod;
            cod=Integer.parseInt(tvCodigo.getText().toString());
            daoDocente.eliminarDocente(cod);
        }
        if(v==btnRegresar){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }

    void cargar(){
        Docente doc= (Docente) getIntent().getSerializableExtra("docente");
        tvCodigo.setText(""+doc.getCodigo());
        edtNombre.setText(doc.getNombres());
        edtPaterno.setText(doc.getPaterno());
        edtMaterno.setText(doc.getMaterno());
        edtSueldo.setText(""+doc.getSueldo());
        edtHijos.setText(""+doc.getHijos());
        //recuperar el adaptador del Spinner spnSexo
        ArrayAdapter adapter= (ArrayAdapter) spnSexo.getAdapter();
        //variable para alcenar el sexo del Docente
        String sexo=doc.getSexo();
        //obtener la posiciòn de la variable sexo dentro del adapter
        int posicion=adapter.getPosition(sexo);
        //mostrar el valor de la posicion en el spinner
        spnSexo.setSelection(posicion);

        //spnSexo;
    }

}