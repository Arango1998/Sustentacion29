
package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.Localidad;
import com.webfutbol2017.backend.persistence.facades.LocalidadFacade;
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
@Named(value = "localidadManagedBean")
@RequestScoped
public class LocalidadManagedBean implements Serializable, InterfaceController<Localidad>{
private Localidad localidad;
@EJB
private LocalidadFacade lf;
    
    public LocalidadManagedBean() {
    }
    
     @PostConstruct
    public void init(){
        localidad = new Localidad();
    }

    @Override
    public Localidad getObjectByKey(Integer key) {
    return lf.find(key);
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    
     public List<Localidad> listar(){
        return lf.findAll();
    }
    
    public void crearLocalidad(){
        lf.create(localidad);
    }
    
    
}
