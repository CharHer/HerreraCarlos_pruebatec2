package com.hackaboss.logica;

import com.hackaboss.logica.Turno;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-01-21T22:27:20")
@StaticMetamodel(Ciudadano.class)
public class Ciudadano_ { 

    public static volatile SingularAttribute<Ciudadano, String> apellido;
    public static volatile SingularAttribute<Ciudadano, String> emailContacto;
    public static volatile SingularAttribute<Ciudadano, Long> id;
    public static volatile SingularAttribute<Ciudadano, String> telefono;
    public static volatile SingularAttribute<Ciudadano, String> nombre;
    public static volatile ListAttribute<Ciudadano, Turno> listaTurnos;

}