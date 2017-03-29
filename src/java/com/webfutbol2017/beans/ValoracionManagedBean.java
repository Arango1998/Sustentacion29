/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.Valoracion;
import com.webfutbol2017.backend.persistence.facades.ValoracionFacade;
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
@Named(value = "valoracionManagedBEan")
@RequestScoped
public class ValoracionManagedBean implements Serializable, InterfaceController<Valoracion>{

    private Valoracion valoracion;
    @EJB
    private ValoracionFacade valf;
    
    public ValoracionManagedBean() {
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }
    
    
    @PostConstruct
    public void init(){
        valoracion = new Valoracion();
    }
    
    public void registrarValoracion(){
        valf.create(valoracion);
    }
    
    public void modificarValoracion(){
        valf.edit(valoracion);
    }
    
    public void eliminarValoracion(Valoracion v){
        valf.remove(valoracion);
    }
    
    public List<Valoracion> listarValoracion(){
        return valf.findAll();
    }
    
    public String actualizarValoracion(Valoracion val){
        valoracion = val;
        return "";
    }
    
 
    @Override
    public Valoracion getObjectByKey(Integer key) {
        return valf.find(key);
    }
    
   
    
}
