/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.Pago;
import com.webfutbol2017.backend.persistence.facades.PagoFacade;
import com.webfutbol2017.converters.InterfaceController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "pagoManagedBean")
@RequestScoped
public class PagoManagedBean implements Serializable, InterfaceController<Pago>{

    /**
     * Creates a new instance of PagoManagedBean
     */
    public PagoManagedBean() {
    }
    private Pago pago;
    @EJB
    private PagoFacade pagof;
    @Inject
    private JugadorManagedBean jugadorM;
    @PostConstruct
    public void init(){
    pago = new Pago();
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public JugadorManagedBean getJugadorM() {
        return jugadorM;
    }

    public void setJugadorM(JugadorManagedBean jugadorM) {
        this.jugadorM = jugadorM;
    }
    
   
    
    public List<Pago> listarPago() {

        return pagof.findAll();
        
    }
    public List<Pago> listarPagoPersonal() {
        List<Pago> pl = new ArrayList<>();
        for (Pago pago: listarPago()) {
            System.out.println(pago);
            if (pago.getFkIdJugador().equals(jugadorM.getJugador())) {
                pl.add(pago);
            }
        }
        return pagof.findAll();
        
    }

    @Override
    public Pago getObjectByKey(Integer key) {
    return pagof.find(key);
    }
}
