package Modelo;

import android.database.Cursor;

import com.example.listviewpersonalisado.alumnoItem;

import java.util.ArrayList;

public interface Proyeccion {

    public alumnoItem getAlumno(String matricula);
    public ArrayList<alumnoItem> allAlumnos();
    public alumnoItem readAlumno(Cursor cursor);


}
