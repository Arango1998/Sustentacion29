
package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.Torneo;
import com.webfutbol2017.backend.persistence.facades.TorneoFacade;
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
@Named(value = "torneoManagedBean")
@RequestScoped
public class TorneoManagedBean implements Serializable, InterfaceController<Torneo>{
    private Torneo torneo;
    @EJB
    private TorneoFacade tf;

    
    public TorneoManagedBean() {
    }
    
     @PostConstruct
    public void init(){
        torneo = new Torneo();
    }

    @Override
    public Torneo getObjectByKey(Integer key) {
    return tf.find(key);
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
    
     
    public List<Torneo> listar(){
        return tf.findAll();
    }
    
    public void create(){
        tf.create(torneo);
    }
    
    
}
