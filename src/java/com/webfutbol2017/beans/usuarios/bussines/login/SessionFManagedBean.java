package com.webfutbol2017.beans.usuarios.bussines.login;

import com.webfutbol2017.backend.persistence.entities.Permiso;
import com.webfutbol2017.backend.persistence.entities.Usuario;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cristian Suesca
 */
@Named
@SessionScoped
public class SessionFManagedBean implements Serializable {

    private Usuario usuarioSesion;

    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }
    
    
    public SessionFManagedBean() {
    }

    @PostConstruct
    public void init() {
        usuarioSesion = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
    
    public List<Permiso> permisos(){
        return usuarioSesion.getIdTipoRol().getPermisoList();
    }
}