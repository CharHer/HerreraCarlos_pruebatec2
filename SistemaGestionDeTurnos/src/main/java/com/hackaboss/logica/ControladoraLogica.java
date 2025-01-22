
package com.hackaboss.logica;

import com.hackaboss.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario (String email, String Password){
        Usuario usu = new Usuario(); //NO ESTOY SEGURO
        usu.setEmail(email);
        usu.setPassword(Password);
        
        controlPersis.crearUsuario(usu);
        
    }
    
    public void crearTurno(String numTurno, String descripTramite, String fechaAgendada, String estado) {
        Turno turn = new Turno();
        turn.setNumeroTurno(numTurno);
        turn.setDescripcionTramite(descripTramite);
        turn.setFechaAgendada(fechaAgendada);
        turn.setEstado(estado);
        
        controlPersis.crearTurno(turn);
        
    }

    public boolean validarAcceso(String email, String password) {
        Usuario usu = controlPersis.buscarUsuario(email);

        if (usu != null) {
            if (usu.getEmail().equals(email)) {
                if (usu.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    

    public List<Turno> getTurnos() {
        return controlPersis.getTurnos();
    }

    public void borrarTurno(Long id) {
        controlPersis.borrarTurno(id);
    }

    public Turno traerTurno(Long id) {
        return controlPersis.traerTurno(id);
    }

    public void editarTurno(Turno turn) {
        controlPersis.editarTurno(turn);
    }

    public void crearCiudadano(String nombre, String apellido, String telefono, String email) {
        Ciudadano ciudadan = new Ciudadano();
        ciudadan.setNombre(nombre);
        ciudadan.setApellido(apellido);
        ciudadan.setTelefono(telefono);
        ciudadan.setEmailContacto(email);
        
        controlPersis.crearCiudadano(ciudadan);
        
    }

    public void crearTramite(String tipoTramite) {
        Tramite tram = new Tramite();
        tram.setTipoDeTramite(tipoTramite);
        
        controlPersis.crearTramite(tram);
    }

    public List<Turno> buscarPorEstado(String busquedaEstado) {
        
        //filtrado desde la logica con lambdas y streams
        
        /*
        return controlPersis.traerTurnos().stream() 
        .filter(turn -> turn.getEstado().equals(busquedaEstado)) 
        .collect(Collectors.toList());
        */
        
        //filtrado desde la BD
        
        List<Turno> turnosCoincidentes = new ArrayList<>();
        turnosCoincidentes = controlPersis.buscarPorEstado(busquedaEstado);
        
        return turnosCoincidentes;
        
    }

    public Ciudadano traerCiudadanoId(Long ciudadanoId) {
        return controlPersis.traerCiudadanoId(ciudadanoId);
    }

    public Tramite traerTramiteId(Long tramiteId) {
        return controlPersis.traerTramiteId(tramiteId);
    }

    public Usuario traerUsuarioId(Long usuarioId) {
        return controlPersis.traerUsuarioId(usuarioId);
        
    }

    



    

    

}
