/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb2017.email;

import com.futbolweb2017.email.Email;

/**
 *
 * @author Felipe
 */
public class TestEmail {
    public static void main(String[] args){
    Email e = new Email("Prueba Consola Email","Este es un mensaje de prueba desde la consola by Adhael ","af8@misena.edu.co");
    e.enviarEmail();

}
}
