package com.test.model.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_matricula")
public class MatriculaEntity {

    @Id
    private String idMatricula;

    private String periodo;
    private String nivel;

    private Date fecha_mat;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<CursoEntity> cursos;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<EstudianteEntity> estudiantes;

    @OneToMany(mappedBy = "matricula")
    private List<NotaEntity> notas;

    public MatriculaEntity() {
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

    public List<CursoEntity> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoEntity> cursos) {
        this.cursos = cursos;
    }

    public List<EstudianteEntity> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteEntity> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Date getFecha_mat() {
        return fecha_mat;
    }

    public void setFecha_mat(Date fecha_mat) {
        this.fecha_mat = fecha_mat;
    }
}
