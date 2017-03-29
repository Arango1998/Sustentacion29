/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.Permiso;
import com.webfutbol2017.backend.persistence.facades.PermisoFacade;
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
@Named(value = "permisoManagedBean")
@RequestScoped
public class PermisoManagedBean implements Serializable, InterfaceController<Permiso>{

  private Permiso permiso;
  @EJB
  private PermisoFacade pf;
    public PermisoManagedBean() {
    }
    
     @PostConstruct
    public void init(){
        permiso = new Permiso();
    }

    @Override
    public Permiso getObjectByKey(Integer key) {
    return pf.find(key);
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    
        public List<Permiso> listar(){
        return pf.findAll();
    }
    
  
    
}
