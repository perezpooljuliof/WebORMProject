/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.tot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Embedded;

/**
 *
 * @author JULIO.PEREZ
 */
@Entity
@Table(name = "MARCADORES")
public class Marcador implements Serializable {
    
    private MarcadorId id;
    private Double anchoMarcador;
    private Double largoMarcador;
    private Integer capasPorTendido;
    private Double consumoPromedio;
    private Double mermaExtremoMarcador;
    private Double puntaYEmpalme;
    private Double mermaPromedioPorCuerpo;
    private Double consumoPromedioDesperdicio;
    private Integer cantidadCapasProgramadas;
    private Integer secuenciaColor;
    private Double aprovechamiento;
    private Double perimetro;
    private Integer estatus;
    private Integer idFamilia;

    @Embedded
    @Id
    public MarcadorId getId() {
        return id;
    }

    public void setId(MarcadorId id) {
        this.id = id;
    }

    @Column(name = "MAR04")
    public Double getAnchoMarcador() {
        return anchoMarcador;
    }

    public void setAnchoMarcador(Double anchoMarcador) {
        this.anchoMarcador = anchoMarcador;
    }

    @Column(name = "MAR05")
    public Double getLargoMarcador() {
        return largoMarcador;
    }

    public void setLargoMarcador(Double largoMarcador) {
        this.largoMarcador = largoMarcador;
    }

    @Column(name = "MAR06")
    public Integer getCapasPorTendido() {
        return capasPorTendido;
    }

    public void setCapasPorTendido(Integer capasPorTendido) {
        this.capasPorTendido = capasPorTendido;
    }

    @Column(name = "MAR07")
    public Double getConsumoPromedio() {
        return consumoPromedio;
    }

    public void setConsumoPromedio(Double consumoPromedio) {
        this.consumoPromedio = consumoPromedio;
    }

    @Column(name = "MAR08")
    public Double getMermaExtremoMarcador() {
        return mermaExtremoMarcador;
    }

    public void setMermaExtremoMarcador(Double mermaExtremoMarcador) {
        this.mermaExtremoMarcador = mermaExtremoMarcador;
    }

    @Column(name = "MAR09")
    public Double getPuntaYEmpalme() {
        return puntaYEmpalme;
    }

    public void setPuntaYEmpalme(Double puntaYEmpalme) {
        this.puntaYEmpalme = puntaYEmpalme;
    }

    @Column(name = "MAR10")
    public Double getMermaPromedioPorCuerpo() {
        return mermaPromedioPorCuerpo;
    }

    public void setMermaPromedioPorCuerpo(Double mermaPromedioPorCuerpo) {
        this.mermaPromedioPorCuerpo = mermaPromedioPorCuerpo;
    }

    @Column(name = "MAR11")
    public Double getConsumoPromedioDesperdicio() {
        return consumoPromedioDesperdicio;
    }

    public void setConsumoPromedioDesperdicio(Double consumoPromedioDesperdicio) {
        this.consumoPromedioDesperdicio = consumoPromedioDesperdicio;
    }

    @Column(name = "MAR13")
    public Integer getCantidadCapasProgramadas() {
        return cantidadCapasProgramadas;
    }

    public void setCantidadCapasProgramadas(Integer cantidadCapasProgramadas) {
        this.cantidadCapasProgramadas = cantidadCapasProgramadas;
    }

    @Column(name = "MAR14")
    public Integer getSecuenciaColor() {
        return secuenciaColor;
    }

    public void setSecuenciaColor(Integer secuenciaColor) {
        this.secuenciaColor = secuenciaColor;
    }

    @Column(name = "MAR15")
    public Double getAprovechamiento() {
        return aprovechamiento;
    }

    public void setAprovechamiento(Double aprovechamiento) {
        this.aprovechamiento = aprovechamiento;
    }

    @Column(name = "MAR16")
    public Double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(Double perimetro) {
        this.perimetro = perimetro;
    }

    @Column(name = "MAR17")
    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    @Column(name = "MAR18")
    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }
    
    @Override
    public String toString() {
        return id.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }            
        
        if(o == null || !(o instanceof Marcador) || id == null) {
            return false;
        }
        
        Marcador m = (Marcador) o;
        return id.equals(m.id);
    }
}
