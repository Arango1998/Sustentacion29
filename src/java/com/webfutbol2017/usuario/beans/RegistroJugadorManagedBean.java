package com.webfutbol2017.usuaribeansos;

import com.webfutbol2017.backend.persistence.entities.Usuario;
import com.webfutbol2017.backend.persistence.facades.UsuarioFacade;
import com.webfutbol2017.beans.EstadoUsuarioManagedBean;
import com.webfutbol2017.beans.RolManagedBean;
import com.webfutbol2017.converters.InterfaceController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "registroJugadorManagedBean")
@RequestScoped
public class RegistroJugadorManagedBean implements Serializable, InterfaceController<Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacade usuarioFacade;
    @Inject
    private EstadoUsuarioManagedBean estadoUsuarioManagedBean;
    @Inject
    private RolManagedBean rolManagedBean;

    public RegistroJugadorManagedBean() {
    }
    
      @PostConstruct
    public void init() {

        usuario = new Usuario();
    }

    @Override
    public Usuario getObjectByKey(Integer key) {
return usuarioFacade.find(key);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoUsuarioManagedBean getEstadoUsuarioManagedBean() {
        return estadoUsuarioManagedBean;
    }

    public void setEstadoUsuarioManagedBean(EstadoUsuarioManagedBean estadoUsuarioManagedBean) {
        this.estadoUsuarioManagedBean = estadoUsuarioManagedBean;
    }

    public RolManagedBean getRolManagedBean() {
        return rolManagedBean;
    }

    public void setRolManagedBean(RolManagedBean rolManagedBean) {
        this.rolManagedBean = rolManagedBean;
    }
    
    
    public void registrarJugador(){
        try {
            usuario.setIdEstado(getEstadoUsuarioManagedBean().getObjectByKey(1));
            usuario.setIdTipoRol(getRolManagedBean().getObjectByKey(3));
            usuarioFacade.create(usuario);
        } catch (Exception e) {
        }
    }
    
}