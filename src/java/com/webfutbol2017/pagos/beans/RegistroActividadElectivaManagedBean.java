/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.pagos.beans;

import com.webfutbol2017.backend.persistence.entities.ActividadElectiva;
import com.webfutbol2017.backend.persistence.facades.ActividadElectivaFacade;
import com.webfutbol2017.converters.InterfaceController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Felipe
 */
@Named(value = "registroActividadElectivaManagedBean")
@RequestScoped
public class RegistroActividadElectivaManagedBean implements Serializable, InterfaceController<ActividadElectiva> {

    /**
     * Creates a new instance of RegistroActividadElectivaManagedBean
     */
    public RegistroActividadElectivaManagedBean() {
    }
    private ActividadElectiva actividadElectiva;
    @EJB
    private ActividadElectivaFacade actividadERf;
    
    @PostConstruct
    public void init() {
        actividadElectiva = new ActividadElectiva();
    }

    public ActividadElectiva getActividadElectiva() {
        return actividadElectiva;
    }

    public void setActividadElectiva(ActividadElectiva actividadElectiva) {
        this.actividadElectiva = actividadElectiva;
    }
    public void crearActividadElectiva() {
        actividadERf.create(actividadElectiva);
    }
     public void modificarActividadElectiva() {
        actividadERf.edit(actividadElectiva);
    }
     public void eliminarActividadElectiva(ActividadElectiva ae) {
        actividadERf.remove(ae);
    }
     public String actualizarActividadElectiva(ActividadElectiva acti){
        actividadElectiva = acti;
        return "";
    }

    @Override
    public ActividadElectiva getObjectByKey(Integer key) {
       return actividadERf.find(key);
    }
}
