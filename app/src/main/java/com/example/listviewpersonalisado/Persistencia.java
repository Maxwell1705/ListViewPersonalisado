package Modelo;

import com.example.listviewpersonalizado.alumnoItem;

public interface Persistencia {

    public void openDataBase();
    public void closeDataBase();
    public long insertAlumno(alumnoItem alumno);
    public long updateAlumno(alumnoItem alumno);
    public void deleteAlumnos(int id);


}
