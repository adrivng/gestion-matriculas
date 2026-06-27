package com.test.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_curso")
public class CursoEntity {

    @Id
    private String idCurso;

    private String nombreCurso;
    private String semestre;
    private String titulo;
    private long creditos;

    public CursoEntity() {
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getCreditos() {
        return creditos;
    }

    public void setCreditos(long creditos) {
        this.creditos = creditos;
    }
}
