/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.PosicionSeguimiento;
import com.webfutbol2017.backend.persistence.facades.PosicionSeguimientoFacade;
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
@Named(value = "posicionSeguimientoManagedBean")
@RequestScoped
public class PosicionSeguimientoManagedBean implements Serializable, InterfaceController<PosicionSeguimiento>{

    private PosicionSeguimiento posicionseguimiento;
    @EJB
    private PosicionSeguimientoFacade psf;
    
    
    public PosicionSeguimientoManagedBean() {
    }

    public PosicionSeguimiento getPosicionseguimiento() {
        return posicionseguimiento;
    }

    public void setPosicionseguimiento(PosicionSeguimiento posicionseguimiento) {
        this.posicionseguimiento = posicionseguimiento;
    }
    
    
    @PostConstruct
    public void init(){
        posicionseguimiento = new PosicionSeguimiento();
    }
    
    public void registrarPosicionSeguimiento(){
        psf.create(posicionseguimiento);
    }
    
    public void modificarPosicionSeguimiento(){
        psf.edit(posicionseguimiento);
    }
    
    public void eliminarPosicionSeguimiento(PosicionSeguimiento ps){
        psf.remove(posicionseguimiento);
    }
    
    public List<PosicionSeguimiento> listarPosicionSeguimiento(){
        return psf.findAll();
    }
    
    public String actualizarPosicionSeguimiento(PosicionSeguimiento poss){
        posicionseguimiento = poss;
        return "";
    }
    
  
    @Override
    public PosicionSeguimiento getObjectByKey(Integer key) {
        return psf.find(key);
    }
    
    
    
}
