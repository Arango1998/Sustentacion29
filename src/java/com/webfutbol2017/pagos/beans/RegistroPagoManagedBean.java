/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webfutbol2017.pagos.beans;

import com.csvreader.CsvReader;
import com.futbolweb2017.email.Email;
import com.webfutbol2017.backend.persistence.entities.Pago;
import com.webfutbol2017.backend.persistence.facades.PagoFacade;
import com.webfutbol2017.beans.JugadorManagedBean;
import com.webfutbol2017.beans.UsuarioManagedBean;
import com.webfutbol2017.converters.InterfaceController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author camila
 */
@Named(value = "registroPagoManagedBean")
@RequestScoped
public class RegistroPagoManagedBean implements Serializable, InterfaceController<Pago> {

    /**
     * Creates a new instance of RegistroPagoManagedBean
     */
    public RegistroPagoManagedBean() {
    }
    
    private Pago pago;
    @EJB
    private PagoFacade pagof;
    @Inject
    private UsuarioManagedBean usuarioC;
    @Inject
    private JugadorManagedBean jugadorC;
    
    Date fechaPago = null;
    int monto = 0;
    String estado = null;
    int idJugador  = 0;
    
         SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
    
     @PostConstruct
    public void init(){
    pago = new Pago();
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
     public void registrarPago(){
    Email envioC;
    envioC = new Email("Novedad de pago", "Se le notifíca que se ha generado un nuevo registro de pago en el club Expreso Rojo, para mas información consultar el control de pagos",jugadorC.getJugador().getUsuario().getCorreo());
    envioC.enviarEmail2();
    pagof.create(pago);
    }
    
    public void eliminarPago(Pago p){
    pagof.remove(p);
    }
    
    public void modificarPago(){
    pagof.edit(pago);
    }

     public String actualizarActividadElectiva(Pago pa){
        pago = pa;
        return "";
    }
    @Override
    public Pago getObjectByKey(Integer key) {
     return pagof.find(key);
    }
    
     public void InsertarDesdeCsv() throws FileNotFoundException, IOException, ParseException  {
    //declaramos las variables que vamos a usar en esta clase. En dichas variables vamos cargar los datos que lee
    //leemos desde nuestro archivo .csv
    
         
         
    CsvReader reader = null;{
    
        //aqui le ponemos el path donde esta ubicado el archivo. OJO..
        //para colocar los path de ubicaciones en windows ahi que psoner // en ves de /
        reader = new CsvReader("c:\\Users\\Felipe\\Sena\\ADSI\\pago.csv");
        reader.setDelimiter(',');
        while(reader.readRecord()){
            
            //aqui cargamos las variables con los datos que estan dentro del archivo
            fechaPago = formato.parse(reader.get(0));
            monto = Integer.parseInt(reader.get(1));
            estado = reader.get(2);
            idJugador = Integer.parseInt(reader.get(3));
            
            
        pago.setFechaPago(fechaPago);
        pago.setMonto(monto);
        pago.setEstado(estado);
        pago.setFkIdJugador(jugadorC.getObjectByKey(idJugador));
        pagof.create(pago);
        }
     }   
     
     }                


}
