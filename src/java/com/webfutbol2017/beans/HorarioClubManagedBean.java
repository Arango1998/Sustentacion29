package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.HorarioClub;
import com.webfutbol2017.backend.persistence.facades.HorarioClubFacade;
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
@Named(value = "horarioClubManagedBean")
@RequestScoped
public class HorarioClubManagedBean implements Serializable, InterfaceController<HorarioClub>{
private HorarioClub horarioClub;
@EJB
private HorarioClubFacade hcf;
  
    public HorarioClubManagedBean() {
    }
    
     @PostConstruct
    public void init(){
        horarioClub = new HorarioClub();
    }

    @Override
    public HorarioClub getObjectByKey(Integer key) {
    return hcf.find(key);
    }

    public HorarioClub getHorarioClub() {
        return horarioClub;
    }

    public void setHorarioClub(HorarioClub horarioClub) {
        this.horarioClub = horarioClub;
    }
    
     public List<HorarioClub> listar(){
        return hcf.findAll();
    }
    
    public void create(){
        hcf.create(horarioClub);
    }
    
}
