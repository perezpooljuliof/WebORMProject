package mx.com.tot.mx.com.tot.dto;

import javax.persistence.*;

/**
 * Created by elver on 1/08/16.
 */
@Entity
@Table(name = "Empleado")
public class Empleado {
    private int id;
    private String nombre;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return nombre + " [" + id + "]";
    }
}
