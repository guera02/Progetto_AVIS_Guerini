/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini.eccezioni;

/**
 *
 * @author stocc
 */
public class eccezioneAVISvuota extends Exception
{
    private String messaggio;
    
    public eccezioneAVISvuota(String messaggio)
    {
        this.messaggio=messaggio;
    }
    
    public String toString()
    {
        String s="";
        s+=messaggio;
        return s;
    }
}
