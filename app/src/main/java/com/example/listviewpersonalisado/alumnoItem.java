package com.example.listviewpersonalisado;

public class alumnoItem {

    private int id;
    private String textNombreAlumno;
    private String textMatricula;
    private Integer fotoAlumno;

    // Constructor de parámetros
    public alumnoItem(String text, String text2, Integer fotoId) {
        this.textNombreAlumno = text;
        this.textMatricula = text2;
        this.fotoAlumno = fotoId;
    }

    public int getTextId() { return id; }
    public void SetTextId(int id) {
        this.id = id;
    }

    public String getTextNombreAlumno() { return textNombreAlumno; }

    public void setTextNombreAlumno(String textNombreAlumno) {
        this.textNombreAlumno = textNombreAlumno;
    }

    public String getTextMatricula() { return textMatricula; }

    public void setTextMatricula(String textMatricula) { this.textMatricula = textMatricula; }

    public Integer getFotoAlumno() { return fotoAlumno; }

    public void setFotoAlumno(Integer fotoAlumno) { this.fotoAlumno = fotoAlumno; }

}

