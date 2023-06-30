package Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.listviewpersonalisado.alumnoItem;

import java.util.ArrayList;

public class AlumnosDb implements Persistencia, Proyeccion {

    private Context context;
    private AlumnoDbHelper helper;
    private SQLiteDatabase db;

    public AlumnosDb(Context context, AlumnoDbHelper helper){
        this.context=context;
        this.helper=helper;
    }

    public AlumnosDb(Context context){
        this.context=context;
        this.helper=new AlumnoDbHelper(this.context);
    }


    @Override
    public void openDataBase() {
        db=helper.getWritableDatabase();
    }

    @Override
    public void closeDataBase() {
        helper.close();
    }

    @Override
    public long insertAlumno(alumnoItem alumno) {

        ContentValues values=new ContentValues();

        values.put(DefineTable.Alumnos.COLUMN_NAME_MATRICULA, alumno.getTextNombreAlumno());
        values.put(DefineTable.Alumnos.COLUMN_NAME_NOMBRE, alumno.getTextMatricula());
        values.put(DefineTable.Alumnos.COLUMN_NAME_CARRERA, alumno.getTextCarrera());
        values.put(DefineTable.Alumnos.COLUMN_NAME_FOTO, alumno.getFotoAlumno());

        this.openDataBase();
        long num = db.insert(DefineTable.Alumnos.TABLE_NAME, null, values);
        this.closeDataBase();
        Log.d("agregar","insertAlumno: "+num);

        return num;
    }

    @Override
    public long updateAlumno(alumnoItem alumno) {
        ContentValues values=new ContentValues();

        values.put(DefineTable.Alumnos.COLUMN_NAME_MATRICULA, alumno.getTextNombreAlumno());
        values.put(DefineTable.Alumnos.COLUMN_NAME_NOMBRE, alumno.getTextMatricula());
        values.put(DefineTable.Alumnos.COLUMN_NAME_CARRERA, alumno.getTextCarrera());
        values.put(DefineTable.Alumnos.COLUMN_NAME_FOTO, alumno.getFotoAlumno());

        this.openDataBase();
        long num = db.update(
                DefineTable.Alumnos.TABLE_NAME,
                values,
                DefineTable.Alumnos.COLUMN_NAME_ID+alumno.getTextId(),
                null);
        this.closeDataBase();
        Log.d("agregar","insertAlumno: "+num);

        return num;
    }

    @Override
    public void deleteAlumnos(int id) {
        this.openDataBase();
        db.delete(
                DefineTable.Alumnos.TABLE_NAME,
                DefineTable.Alumnos.COLUMN_NAME_ID+"=?",
                new String[] {String.valueOf(id)});
        this.closeDataBase();
    }


    @Override
    public alumnoItem getAlumno(String matricula) {
        db=helper.getWritableDatabase();

        Cursor cursor=db.query(
                DefineTable.Alumnos.TABLE_NAME,
                DefineTable.Alumnos.REGISTRO,
                DefineTable.Alumnos.COLUMN_NAME_ID+" = ?",
                new String[] {matricula},
                null, null, null);
        cursor.moveToFirst();
        alumnoItem alumno=readAlumno(cursor);

        return alumno;
    }

    @Override
    public ArrayList<alumnoItem> allAlumnos() {
        db=helper.getWritableDatabase();

        Cursor cursor=db.query(
                DefineTable.Alumnos.TABLE_NAME,
                DefineTable.Alumnos.REGISTRO,
                null, null, null, null, null);
        ArrayList<alumnoItem> alumnos = new ArrayList<alumnoItem>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            alumnoItem alumno=readAlumno(cursor);
            alumnos.add(alumno);
            cursor.moveToNext();
        }

        cursor.close();
        return alumnos;
    }

    @Override
    public alumnoItem readAlumno(Cursor cursor) {
        alumnoItem alumno = new alumnoItem();

        alumno.setTextId(cursor.getInt(0));
        alumno.setTextNombreAlumno(cursor.getString(1));
        alumno.setTextMatricula(cursor.getString(2));
        alumno.setTextCarrera(cursor.getString(3));

        return alumno;
    }


}
