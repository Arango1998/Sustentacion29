/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.pagos.beans;

import com.futbolweb2017.email.Email;
import com.webfutbol2017.backend.persistence.entities.Pago;
import com.webfutbol2017.backend.persistence.facades.PagoFacade;
import com.webfutbol2017.beans.JugadorManagedBean;
import com.webfutbol2017.beans.UsuarioManagedBean;
import com.webfutbol2017.converters.InterfaceController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author camila
 */
@Named(value = "registroPagoManagedBean")
@RequestScoped
public class RegistroPagoManagedBean implements Serializable, InterfaceController<Pago> {

    /**
     * Creates a new instance of RegistroPagoManagedBean
     */
    public RegistroPagoManagedBean() {
    }
    
    private Pago pago;
    @EJB
    private PagoFacade pagof;
    @Inject
    private UsuarioManagedBean usuarioC;
    @Inject
    private JugadorManagedBean jugadorC;
    
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
    
     public void registrarPago(){
    Email envioC;
    envioC = new Email("Novedad de pago", "Se le notifíca que se ha generado un nuevo registro de pago en el club Expreso Rojo, para mas información consultar el control de pagos",jugadorC.getJugador().getUsuario().getCorreo());
    envioC.enviarEmail2();
    pagof.create(pago);
    }
    
    public void eliminarPago(Pago p){
    pagof.remove(p);
    }
    
    public void modificarPago(){
    pagof.edit(pago);
    }

     public String actualizarActividadElectiva(Pago pa){
        pago = pa;
        return "";
    }
    @Override
    public Pago getObjectByKey(Integer key) {
     return pagof.find(key);
    }
}
