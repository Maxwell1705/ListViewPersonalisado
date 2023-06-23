package com.example.listviewpersonalisado;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterAlumno extends BaseAdapter implements Filterable {
    /*int groupId;
    Activity Context;
    ArrayList<alumnoItem> list;
    ArrayList<alumnoItem> listaOriginal;*/
    LayoutInflater inflater;
    private Context nContext;
    private List<alumnoItem> nData;
    private List<alumnoItem> nFilteredData;

    public AdapterAlumno(Context context, List<alumnoItem> data) {
        nContext = context;
        nData = data;
        nFilteredData = new ArrayList<>(data);
    }

    @Override
    public int getCount() {
        return nFilteredData.size();
    }

    @Override
    public Object getItem(int posicion) {
        return nFilteredData.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    public View getView(int posicion, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(nContext);
            convertView = inflater.inflate(R.layout.alumnoitem_layout, parent, false);

            holder = new ViewHolder();
            holder.imgFoto = convertView.findViewById(R.id.imgAlumno);
            holder.lblMatricula = convertView.findViewById(R.id.lblNombres);
            holder.lblNombre = convertView.findViewById(R.id.lblMatriculas);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        alumnoItem item = nFilteredData.get(posicion);

        holder.imgFoto.setImageResource(item.getFotoAlumno());
        holder.lblMatricula.setText(item.getTextNombreAlumno());
        holder.lblNombre.setText(item.getTextMatricula());

        return convertView;
    }
    public View getDropDownView(int posicion, View convertView,ViewGroup parent) {
        return getView(posicion,convertView,parent);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<alumnoItem> filteredList = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(nData);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (alumnoItem item : nData) {
                        if (item.getTextMatricula().toLowerCase().contains(filterPattern) ||
                                item.getTextNombreAlumno().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }
                    }
                }

                results.values = filteredList;
                results.count = filteredList.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                nFilteredData.clear();
                nFilteredData.addAll((List<alumnoItem>) results.values);
                notifyDataSetChanged();
            }
        };
    }


    static class ViewHolder {
        ImageView imgFoto;
        TextView lblMatricula;
        TextView lblNombre;
    }

}
