package com.example.lab_android02_18_06_22.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab_android02_18_06_22.R;
import com.example.lab_android02_18_06_22.entidad.Docente;

import java.util.ArrayList;

public class AdaptadorDocente extends BaseAdapter {

    private ArrayList<Docente> lista;
    private Context contexto;

    public AdaptadorDocente(ArrayList<Docente> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        TextView tvCodigo,tvNombre,tvPaterno,tvMaterno;

        //crear inflador
        LayoutInflater inflater=(LayoutInflater)
                contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row=inflater.inflate(R.layout.data,parent,false);
        tvCodigo= row.findViewById(R.id.tvCodigo);
        tvNombre=row.findViewById(R.id.tvNombre);
        tvPaterno=row.findViewById(R.id.tvPaterno);
        tvMaterno=row.findViewById(R.id.tvMaterno);
        tvCodigo.setText(""+lista.get(position).getCodigo());
        tvNombre.setText(lista.get(position).getNombres());
        tvPaterno.setText(lista.get(position).getPaterno());
        tvMaterno.setText(lista.get(position).getMaterno());

        return row;
    }

}
