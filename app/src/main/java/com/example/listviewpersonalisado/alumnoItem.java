package com.example.listviewpersonalisado;

public class alumnoItem {

    private int id;
    private String carrera;
    private String textNombreAlumno;
    private String textMatricula;
    private Integer fotoAlumno;

    public alumnoItem(){}

    public alumnoItem(String text, String text2, Integer fotoId, String carrera) {
        this.textNombreAlumno = text;
        this.textMatricula = text2;
        this.fotoAlumno = fotoId;
        this.carrera = carrera;
    }

    public int getTextId() { return id; }
    public void setTextId(int id) {
        this.id = id;
    }
    public String getTextCarrera() { return carrera; }
    public void setTextCarrera(String carrera) { this.carrera = carrera; }


    public String getTextNombreAlumno() { return textNombreAlumno; }

    public void setTextNombreAlumno(String textNombreAlumno) {
        this.textNombreAlumno = textNombreAlumno;
    }

    public String getTextMatricula() { return textMatricula; }

    public void setTextMatricula(String textMatricula) { this.textMatricula = textMatricula; }

    public Integer getFotoAlumno() { return fotoAlumno; }

    public void setFotoAlumno(Integer fotoAlumno) { this.fotoAlumno = fotoAlumno; }

}

