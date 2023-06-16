package com.example.listviewpersonalisado;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAlumno extends ArrayAdapter<alumnoItem> {
    int groupId;
    Activity Context;
    ArrayList<alumnoItem> list;
    LayoutInflater inflater;

    public AdapterAlumno (Activity Context, int groupId, int id, ArrayList<alumnoItem> list) {
        super(Context, id, list);
        this.list = list;
        inflater = (LayoutInflater) Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupId = groupId;
    }

    public View getView(int posicion, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupId, parent,false);
        ImageView imagen = (ImageView) itemView.findViewById(R.id.imgAlumno);
        imagen.setImageResource(list.get(posicion).getFotoAlumno());
        TextView textMatricula = (TextView)
                itemView.findViewById(R.id.lblMatriculas);
        textMatricula.setText(list.get(posicion).getTextMatricula());
        TextView textNombreAlumno = (TextView)
                itemView.findViewById(R.id.lblNombres);
        textNombreAlumno.setText(list.get(posicion).getTextNombreAlumno());
        return itemView;
    }
    public View getDropDownView(int posicion, View convertView,ViewGroup parent) {
        return getView(posicion,convertView,parent);
    }
}
