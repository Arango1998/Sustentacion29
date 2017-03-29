package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.Equipo;
import com.webfutbol2017.backend.persistence.facades.EquipoFacade;
import com.webfutbol2017.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "equipoManagedBean")
@RequestScoped
public class EquipoManagedBean implements Serializable, InterfaceController<Equipo> {

    private Equipo equipo;
    @EJB
    private EquipoFacade ef;

    public EquipoManagedBean() {
    }

    @PostConstruct
    public void init() {
        equipo = new Equipo();
    }

    @Override
    public Equipo getObjectByKey(Integer key) {
        return ef.find(key);
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
      public List<Equipo> listar(){
        return ef.findAll();
    }
    
    public void crearEquipo(){
        ef.create(equipo);
    }
    

}
