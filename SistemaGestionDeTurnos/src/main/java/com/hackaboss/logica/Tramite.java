
package com.hackaboss.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tramite implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoDeTramite;
    

    public Tramite() {
    }

    public Tramite(String tipoDeTramite) {
        this.tipoDeTramite = tipoDeTramite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeTramite() {
        return tipoDeTramite;
    }

    public void setTipoDeTramite(String tipoDeTramite) {
        this.tipoDeTramite = tipoDeTramite;
    }
    

}
