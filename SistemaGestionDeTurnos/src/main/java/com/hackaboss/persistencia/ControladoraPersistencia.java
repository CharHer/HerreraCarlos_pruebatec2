
package com.hackaboss.persistencia;

import com.hackaboss.logica.Ciudadano;
import com.hackaboss.logica.Tramite;
import com.hackaboss.logica.Turno;
import com.hackaboss.logica.Usuario;
import com.hackaboss.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
        UsuarioJpaController usuJpa = new UsuarioJpaController();
        TurnoJpaController turnJpa = new TurnoJpaController();
        CiudadanoJpaController ciuJpa = new CiudadanoJpaController();
        TramiteJpaController tramJpa = new TramiteJpaController();

    public void crearUsuario(Usuario usu) { //NO ESTOY SEGURO, tal vez implementar la creacion de usuario en el login
        usuJpa.create(usu);
    }

    public Usuario buscarUsuario(String email) {
        return usuJpa.findUserByEmail(email);
    }
    
    public void crearTurno(Turno turn) {
        turnJpa.create(turn);
    }
    
    public Ciudadano traerCiudadanoId(Long ciudadanoId) {
        return ciuJpa.findCiudadano(ciudadanoId);
    }

    public Tramite traerTramiteId(Long tramiteId) {
        return tramJpa.findTramite(tramiteId);
    }

    public Usuario traerUsuarioId(Long usuarioId) {
        return usuJpa.findUsuario(usuarioId);
    }
    
    public List<Turno> getTurnos() {
        return turnJpa.findTurnoEntities();
    }

    public void borrarTurno(Long id) {
            try {
                turnJpa.destroy(id);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public Turno traerTurno(Long id) {
        return turnJpa.findTurno(id);
    }

    public void editarTurno(Turno turn) {
            try {
                turnJpa.edit(turn);
            } catch (Exception ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void crearCiudadano(Ciudadano ciudadan) {
        ciuJpa.create(ciudadan);
    }

    public void crearTramite(Tramite tram) {
        tramJpa.create(tram);
    }

    public List<Turno> traerTurnos() {
        return turnJpa.findTurnoEntities();
    }

    public List<Turno> buscarPorEstado(String busquedaEstado) {
        return turnJpa.findTurnoByEstado(busquedaEstado);
    }

    


}
