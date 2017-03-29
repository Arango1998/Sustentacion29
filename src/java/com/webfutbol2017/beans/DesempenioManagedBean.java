/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.Desempenio;
import com.webfutbol2017.backend.persistence.facades.DesempenioFacade;
import com.webfutbol2017.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Iesua
 */
@Named(value = "desempenioManagedBean")
@RequestScoped
public class DesempenioManagedBean implements Serializable, InterfaceController<Desempenio> {

    private Desempenio desempenio;
    @EJB
    private DesempenioFacade desf;
            
    public DesempenioManagedBean() {
    }

    public Desempenio getDesempenio() {
        return desempenio;
    }

    public void setDesempenio(Desempenio desempenio) {
        this.desempenio = desempenio;
    }
    
    
    @PostConstruct
    public void init(){
        desempenio = new Desempenio();
    }
    
    
    public void registrarDesempenio(){
        desf.create(desempenio);
    }
    
    public void modificarDesempenio(){
        desf.edit(desempenio);
    }
    
    public void eliminarDesempenio(Desempenio d){
        desf.remove(desempenio);
    }
    
    public List<Desempenio> listarDesempenio(){
        return desf.findAll();
    }
    
    public String actualizarDesempenio(Desempenio des){
        desempenio = des;
        return "";
    }
    
    

    @Override
    public Desempenio getObjectByKey(Integer key) {
        return desf.find(key);
    }
}
