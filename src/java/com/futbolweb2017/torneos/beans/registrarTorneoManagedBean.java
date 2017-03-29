/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb2017.torneos.beans;

import com.webfutbol2017.backend.persistence.entities.Torneo;
import com.webfutbol2017.backend.persistence.facades.TorneoFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author camila
 */
@Named(value = "registrarTorneoManagedBean")
@RequestScoped
public class registrarTorneoManagedBean {

  private Torneo torneo;
  @EJB
  private TorneoFacade TorneoEJB;
    
  
  public registrarTorneoManagedBean() {
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
  
    public void init(){
    
    torneo = new Torneo();
    
    }
    
    public void registrarTorneo(){
    
    TorneoEJB.create(torneo);
    
    }
    
    public void editarTorneo(){
    
        TorneoEJB.edit(torneo);
    }
}
