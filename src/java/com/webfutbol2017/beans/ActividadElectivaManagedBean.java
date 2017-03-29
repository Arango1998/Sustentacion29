/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.ActividadElectiva;
import com.webfutbol2017.backend.persistence.facades.ActividadElectivaFacade;
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
@Named(value = "actividadElectivaManagedBean")
@RequestScoped
public class ActividadElectivaManagedBean implements Serializable, InterfaceController<ActividadElectiva> {

    private ActividadElectiva actividadElectiva;
    @EJB
    private ActividadElectivaFacade actividadEf;

    public ActividadElectivaManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        actividadElectiva = new ActividadElectiva();
    }
    
    @Override
    public ActividadElectiva getObjectByKey(Integer key) {
        return actividadEf.find(key);
    }
    
    public ActividadElectiva getActividadElectiva() {
        return actividadElectiva;
    }
    
    public void setActividadElectiva(ActividadElectiva actividadElectiva) {
        this.actividadElectiva = actividadElectiva;
    }
    
    public List<ActividadElectiva> listar() {
        return actividadEf.findAll();
    }
    
    public void crearActividadElectiva() {
        actividadEf.create(actividadElectiva);
    }
    
}
