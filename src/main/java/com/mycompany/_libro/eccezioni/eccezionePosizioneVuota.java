/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._libro.eccezioni;

/**
 *
 * @author stocc
 */
public class eccezionePosizioneVuota extends Exception
{
    private int posizione;

    public eccezionePosizioneVuota(int posizione)
    {
        this.posizione=posizione;
    }

    public int getPosizione() 
    {
        return posizione;
    }
    
    public String toString()
    {
        String s="";
        s+="La posizione: "+getPosizione()+" è vuota.";
        return s;
    }
    
}
