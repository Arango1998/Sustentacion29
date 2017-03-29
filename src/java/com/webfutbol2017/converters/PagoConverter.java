/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.converters;

import com.webfutbol2017.backend.persistence.entities.Pago;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristian Suesca
 */
@FacesConverter (forClass = Pago.class)
public class PagoConverter extends AbstractConverter {

    public PagoConverter() {
    super.nameManagedBean = "pagoManagedBean";
    }
    
}
