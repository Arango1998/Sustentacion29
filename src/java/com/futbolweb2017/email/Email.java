/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb2017.email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Felipe
 */
public class Email {
    
     private final static String HOST = "smtp.gmail.com";
    private final static String PORT = "25"; //25 o 587
    private final static String REMITENTE="futbolweb2017@gmail.com";
    private final static String REMITENTE_PASS = "futbolweb";

    private String asunto;
    private String mensaje;
    private String destinatario;

    private Properties propiedades;

    public Email() {
        inicializarPropiedades();
    }

    public Email(String asunto, String mensaje, String destinatario) {
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        inicializarPropiedades();
    }

    private void inicializarPropiedades() {
        propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", HOST);
        propiedades.put("mail.smtp.port", PORT);
        propiedades.put("mail.smtp.starttls.enable", "true");
        
    }

    private Session getSession() {
        Authenticator a = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, REMITENTE_PASS);
            }

        };
        return Session.getInstance(propiedades, a);
    }

    public void enviarEmail() {

        try {
            Session session = getSession();
            Message msj = new MimeMessage(session);
            msj.setFrom(new InternetAddress(REMITENTE));
            msj.setSubject(this.asunto);
            msj.setText(this.mensaje);
            msj.setRecipient(Message.RecipientType.TO, new InternetAddress(this.destinatario));

            Transport.send(msj);

        } catch (AddressException ex) {
            System.out.println("La direccion de correo no es valida");
        } catch (MessagingException ex) {

            System.out.println("Se ha presentado un error");
            ex.printStackTrace();
        }

    }

    public void enviarEmail2() {

        try {
            Session session = getSession();
            Message msj = new MimeMessage(session);
            msj.setFrom(new InternetAddress(REMITENTE));
            msj.setSubject(this.asunto);
            msj.setText(this.mensaje);
            msj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(
                    this.destinatario));

            Transport.send(msj);

        } catch (AddressException ex) {
            System.out.println("La direccion de correo no es valida");
        } catch (MessagingException ex) {

            System.out.println("Se ha presentado un error");
            ex.printStackTrace();
        }

    }

    public void enviarEmailhtml() {

        try {
            Session session = getSession();
            Message msj = new MimeMessage(session);
            msj.setFrom(new InternetAddress(REMITENTE));
            msj.setSubject(this.asunto);
            msj.setContent(this.mensaje, "text/html");
            msj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(
                    this.destinatario));

            Transport.send(msj);

        } catch (AddressException ex) {
            System.out.println("La direccion de correo no es valida");
        } catch (MessagingException ex) {

            System.out.println("Se ha presentado un error");
            ex.printStackTrace();
        }

    }
}
