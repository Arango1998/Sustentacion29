/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.usuario.beans;

import com.webfutbol2017.backend.persistence.entities.Usuario;
import com.webfutbol2017.backend.persistence.facades.UsuarioFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "loginManagedBean")
@RequestScoped
public class LoginManagedBean implements Serializable{
    @EJB
    private Usuario user;
    private String documento;
    private String clave; 

 
    public LoginManagedBean() {
    }
    
    @PostConstruct 
    public void init(){
    
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public void iniciarSession(){
        
            
        
    }
    
    
}
