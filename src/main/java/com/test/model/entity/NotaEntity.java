package com.test.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_nota")
public class NotaEntity {

    @ManyToOne
    private MatriculaEntity matricula;

    @Id
    private Long idNota;

    private BigDecimal nota;

    @Column(name = "tipo_evaluacion")
    private String tipoEvaluacion;

    private double porcentaje;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    private String comentario;

    public NotaEntity() {
    }

    public MatriculaEntity getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaEntity matricula) {
        this.matricula = matricula;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
