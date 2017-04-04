/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.beans.usuarios.bussines.login;

import com.webfutbol2017.backend.persistence.entities.Usuario;
import com.webfutbol2017.backend.persistence.facades.AbstractFacade;
import com.webfutbol2017.backend.persistence.facades.UsuarioFacade;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Cristian Suesca
 */
@Stateful
public class UsuarioSessionBean {

    @PersistenceContext(unitName = "webfutbol2017PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioSessionBean() {
    }

   public Object autenticarSesionUsuario(String documento, String clave) {
        try {
            Usuario usuario = getEntityManager().createNamedQuery("Usuario.findByDocumento", Usuario.class).setParameter("documento", documento).getSingleResult();
            if (usuario != null) {
                if (usuario.getClave().equals(clave)) {
                  //falta captura usuario
                    if (!usuario.getIdEstado().getIdEstado().equals(1)) {
                        System.out.println("Activo");
                        return usuario;
                        //Consulta o proceso que cambie el estado al loguarse
                    } else {
                        System.out.println("Estado Inactivo");
                        return 4;
                    }
                }else {
                    return 3;
                }
            }else{
                return 2;
            }
        } catch (Exception e) {
            System.out.println("Error!");
            return 1;
        }
    }

}
