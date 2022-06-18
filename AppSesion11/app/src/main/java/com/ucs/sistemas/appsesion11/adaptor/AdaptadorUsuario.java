package com.ucs.sistemas.appsesion11.adaptor;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ucs.sistemas.appsesion11.R;
import com.ucs.sistemas.appsesion11.entidad.Usuario;

import java.util.ArrayList;


public class AdaptadorUsuario extends BaseAdapter {
   //variables
   private ArrayList<Usuario> lista;
   private Context contexto;

    public AdaptadorUsuario(ArrayList<Usuario> lista, Context contexto) {
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
        TextView tvcodigoa,tvusuarioa,tvpassworda;
       // Crear el infldor con el método inflate()
        LayoutInflater inflater=(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       row=inflater.inflate(R.layout.item_usuario,parent,false);
       tvcodigoa=row.findViewById(R.id.tvcodigo);
       tvusuarioa=row.findViewById(R.id.tvusuario);
       tvpassworda=row.findViewById(R.id.tvpassword);

       tvcodigoa.setText(""+lista.get(position).getId());
       tvusuarioa.setText(lista.get(position).getUsuario());
       tvpassworda.setText(lista.get(position).getPassword());
        return row;
    }
}








