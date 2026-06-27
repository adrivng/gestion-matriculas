package com.test.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class CursoRequest {

    @NotBlank(message = "El ID del curso es obligatorio")
    private String idCurso;

    @NotBlank(message = "El nombre del curso es obligatorio")
    private String nombreCurso;

    @NotBlank(message = "El semestre es obligatorio")
    private String semestre;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @PositiveOrZero(message = "Los créditos deben ser un valor positivo o cero")
    private long creditos;

    public CursoRequest() {
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
