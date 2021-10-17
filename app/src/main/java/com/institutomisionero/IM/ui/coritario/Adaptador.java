package com.institutomisionero.IM.ui.coritario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.institutomisionero.IM.R;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends BaseAdapter implements Filterable{

    Context contexto;
    List<Datos> ListaObjetos;
    List<Datos> ListaObjetosFiltrado;

    public Adaptador(Context contexto, ArrayList<Datos> listaObjetos) {
        this.contexto = contexto;
        this.ListaObjetos = listaObjetos;
        this.ListaObjetosFiltrado = listaObjetos;
    }

    //Retorna cantidad de elementos de la vista
    @Override
    public int getCount() {
        return this.ListaObjetos.size();
    }

    //Retorna objeto puntual de la posicion que indico
    @Override
    public Object getItem(int i) {
        return this.ListaObjetos.get(i);
    }

    //Retorna Id del objeto puntual de la posicion que indico
    @Override
    public long getItemId(int i) {
        return this.ListaObjetos.get(i).getId();
    }


    //Se ejecuta en cada secuencia de cada hito de la listview
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Inyectamos el layout definido dentro de la vista del ListView
        LayoutInflater inflate = LayoutInflater.from(contexto);
        View vista = inflate.inflate(R.layout.list_item, null);

        //Referenciamos el titulo
        TextView titulo = vista.findViewById(R.id.textView);
        titulo.setText(ListaObjetos.get(i).getTitulo().toString());

        TextView posicion = vista.findViewById(R.id.pos);
        posicion.setText(String.valueOf(ListaObjetos.get(i).getId()));

        return vista;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();

                if(constraint == null || constraint.length() == 0){
                    filterResults.count = ListaObjetosFiltrado.size();
                    filterResults.values = ListaObjetosFiltrado;
                }

                else{
                    String searchStr = constraint.toString().toLowerCase();
                    ArrayList<Datos> resultData = new ArrayList<>();

                    for (Datos datos:ListaObjetosFiltrado) {
                        if (datos.getTitulo().toString().toLowerCase().contains(searchStr) ||
                                String.valueOf(datos.getId()).toLowerCase().contains(searchStr)){
                            resultData.add(datos);
                        }
                    }

                    filterResults.count = resultData.size();
                    filterResults.values = resultData;
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                ListaObjetos = (ArrayList<Datos>) results.values;

                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
