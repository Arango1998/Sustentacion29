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
public class UsuarioSessionBean extends AbstractFacade<Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacade usuarioFacade;
    private HttpServletRequest httpServletRequest;

    @PersistenceContext(unitName = "webfutbol2017PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioSessionBean() {
        super(Usuario.class);
    }

   public Object autenticarSesionUsuario(String documento, String clave) {
        try {
            usuario = getEntityManager().createNamedQuery("Usuario.findByIdUsuario", Usuario.class).setParameter("documento", documento).getSingleResult();
            if (usuario != null) {
                if (usuario.getClave().equals(clave)) {
                  //falta captura usuario
                    if (usuario.getIdEstado().getIdEstado().equals(1)) {
                        System.out.println("Estado Inactivo");
                        return 4;
                        //Consulta o proceso que cambie el estado al loguarse
                    } else {
                        System.out.println("Activo");
                        return usuario;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error!");
            return 1;
        }return "";
    }

}
