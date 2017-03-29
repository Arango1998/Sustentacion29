package com.webfutbol2017.beans.usuarios.bussines.login;

import com.webfutbol2017.backend.persistence.entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "sessionFManagedBean")
@ConversationScoped
public class SessionFManagedBean implements Serializable {

    private String documento;
    private String clave;

    @Inject
    private Conversation conversation;
    
     @EJB
    private UsuarioSessionBean usuarioManaged;

    public SessionFManagedBean() {
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
    
    
    @PostConstruct
    public void init() {
        documento = "";
        clave = "";
    }
    
    
    public String ingresar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Object objeto = usuarioManaged.autenticarSesionUsuario(documento, clave);
            if (objeto instanceof Integer) {
                switch ((Integer) objeto) {
                    case 1:
                        context.addMessage(null, new FacesMessage("Ocurrio un Error al Validar el Usuario"));
                        break;
                    case 2:
                        context.addMessage(null, new FacesMessage("El usuario NO está registrado en el sistema"));
                        break;
                    case 3:
                        context.addMessage(null, new FacesMessage("Clave Incorrecta... Intentelo de Nuevo"));
                        break;
                    case 4://Pendiente.. porque aun inactivo ingresa!
                        context.addMessage(null, new FacesMessage("El usuario no tiene Permisos para ingresar"));
                        break;
                }
            } else if (objeto instanceof Usuario) {
                Usuario usuario = (Usuario) objeto;
                context.getExternalContext().getSessionMap().put("usuario", usuario);
                return "/faces/protegido/inicio.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
        }
        return null;
    }


}
