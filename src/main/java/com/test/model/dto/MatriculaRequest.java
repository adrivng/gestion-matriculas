package com.test.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class MatriculaRequest {

    @NotBlank(message = "El ID de matrícula es obligatorio")
    private String idMatricula;

    @NotBlank(message = "El período es obligatorio")
    private String periodo;

    @NotBlank(message = "El nivel es obligatorio")
    private String nivel;

    @NotNull(message = "La fecha de matrícula es obligatoria")
    private Date fecha_mat;

    @NotEmpty(message = "Debe seleccionar al menos un curso")
    private List<@NotBlank String> cursos;

    @NotEmpty(message = "Debe seleccionar al menos un estudiante")
    private List<@NotBlank String> estudiantes;


    public MatriculaRequest() {
    }

    public String getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Date getFecha_mat() {
        return fecha_mat;
    }

    public void setFecha_mat(Date fecha_mat) {
        this.fecha_mat = fecha_mat;
    }

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }

    public List<String> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<String> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
