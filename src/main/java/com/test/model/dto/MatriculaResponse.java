package com.test.model.dto;

import java.util.Date;
import java.util.List;

public class MatriculaResponse {

    private String idMatricula;
    private String periodo;
    private String nivel;
    private Date fecha_mat;
    private List<Curso> cursos;
    private List<Estudiante> estudiantes;

    public MatriculaResponse() {
    }

    public static class Curso {
        private String idCurso;
        private String nombreCurso;
        private String semestre;
        private String titulo;
        private long creditos;

        public Curso() {
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

    public static class Estudiante {
        private String idEstudiante;
        private String nombre;
        private String apellido;
        private String direccion;
        private String telefono;

        public Estudiante() {
        }

        public String getIdEstudiante() {
            return idEstudiante;
        }

        public void setIdEstudiante(String idEstudiante) {
            this.idEstudiante = idEstudiante;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
