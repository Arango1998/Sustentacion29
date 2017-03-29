package com.webfutbol2017.usuario.beans;

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
@Named(value = "registroUsuarioManagedBean")
@RequestScoped
public class RegistroUsuarioManagedBean implements Serializable, InterfaceController<Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacade usuarioRFacade;
    @Inject
    private EstadoUsuarioManagedBean estadoUsuarioManagedBean;
    @Inject
    private RolManagedBean rolManagedBean;

    public RegistroUsuarioManagedBean() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    @Override
    public Usuario getObjectByKey(Integer key) {
        return usuarioRFacade.find(key);
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

    public void creaUsuarioInvitado() {
        try {
            usuario.setIdEstado(getEstadoUsuarioManagedBean().getObjectByKey(1));
            usuario.setIdTipoRol(getRolManagedBean().getObjectByKey(5));
            usuarioRFacade.create(usuario);
        } catch (Exception e) {
        }

    }

}
