
package com.webfutbol2017.converters;

import com.webfutbol2017.backend.persistence.entities.HorarioClub;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristian Suesca
 */

@FacesConverter (forClass = HorarioClub.class)
public class HorarioClubConverter extends AbstractConverter{
    public HorarioClubConverter(){
    this.nameManagedBean = "horarioClubManagedBean";
    }
}
