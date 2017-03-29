package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.Barrio;
import com.webfutbol2017.backend.persistence.facades.BarrioFacade;
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
@Named(value = "barrioManagedBean")
@RequestScoped
public class BarrioManagedBean implements Serializable, InterfaceController<Barrio>{
private Barrio barrio;
@EJB
private BarrioFacade bf;
  
    public BarrioManagedBean() {
    }
    
      @PostConstruct
    public void init(){
        barrio = new Barrio();
    }

    @Override
    public Barrio getObjectByKey(Integer key) {
    return bf.find(key);
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }
    
      public List<Barrio> listar(){
        return bf.findAll();
    }
      
       public void crearBarrio(){
        bf.create(barrio);
    }
    
    
}
