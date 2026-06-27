package com.test.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NotaRequest {

    @NotNull(message = "El ID de nota es obligatorio")
    private Long idNota;

    @NotNull(message = "La nota es obligatoria")
    @Positive(message = "La nota debe ser positiva")
    private BigDecimal nota;

    @NotBlank(message = "El tipo de evaluación es obligatorio")
    private String tipoEvaluacion;

    @Positive(message = "El porcentaje debe ser positivo")
    private double porcentaje;

    @NotNull(message = "La fecha de registro es obligatoria")
    private LocalDateTime fechaRegistro;

    private String comentario;

    public NotaRequest() {
    }

    public NotaRequest(Long idNota, BigDecimal nota, String tipoEvaluacion, double porcentaje, LocalDateTime fechaRegistro, String comentario) {
        this.idNota = idNota;
        this.nota = nota;
        this.tipoEvaluacion = tipoEvaluacion;
        this.porcentaje = porcentaje;
        this.fechaRegistro = fechaRegistro;
        this.comentario = comentario;
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
