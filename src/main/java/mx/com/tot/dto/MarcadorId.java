/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.tot.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author julio.perez
 */
@Embeddable
public class MarcadorId implements Serializable {
    private Integer idPedido;
    private Integer idColorPieza;
    private Integer numeroMarcador;
    private Integer numeroReposicion;
    
    public MarcadorId() {}
    
    public MarcadorId(Integer idPedido, Integer idColorPieza, Integer numeroMarcador, Integer numeroReposicion) {
        this.idPedido = idPedido;
        this.idColorPieza = idColorPieza;
        this.numeroMarcador = numeroMarcador;
        this.numeroReposicion = numeroReposicion;
    }

    @Column(name = "MAR01")
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    @Column(name = "MAR02")
    public Integer getIdColorPieza() {
        return idColorPieza;
    }

    public void setIdColorPieza(Integer idColorPieza) {
        this.idColorPieza = idColorPieza;
    }

    @Column(name = "MAR03")
    public Integer getNumeroMarcador() {
        return numeroMarcador;
    }

    public void setNumeroMarcador(Integer numeroMarcador) {
        this.numeroMarcador = numeroMarcador;
    }

    @Column(name = "MAR12")
    public Integer getNumeroReposicion() {
        return numeroReposicion;
    }

    public void setNumeroReposicion(Integer numeroReposicion) {
        this.numeroReposicion = numeroReposicion;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        if(idPedido != null) {
            hashCode += idPedido;
        }
        if(idColorPieza != null) {
            hashCode += idColorPieza;
        }
        
        return hashCode;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        
        if(o == null || !(o instanceof MarcadorId) || idPedido == null || idColorPieza == null 
                || numeroMarcador == null || numeroReposicion == null) {
            return false;
        }
        
        MarcadorId m = (MarcadorId) o;
        return idPedido.equals(m.idPedido) && idColorPieza.equals(m.idColorPieza) 
                && numeroMarcador.equals(m.numeroMarcador) && numeroReposicion.equals(m.numeroReposicion);
    }
    
    public String toString() {
        return "[" + idPedido + ", " + idColorPieza + ", " + numeroMarcador + ", " + numeroReposicion + "]";
    }
}
