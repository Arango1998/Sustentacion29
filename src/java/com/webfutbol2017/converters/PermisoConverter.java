
package com.webfutbol2017.converters;

import com.webfutbol2017.backend.persistence.entities.Permiso;
import javax.faces.convert.FacesConverter;

@FacesConverter (forClass = Permiso.class)
public class PermisoConverter extends AbstractConverter{
    public PermisoConverter(){
    this.nameManagedBean = "permisoManagedBean";
    }
}
