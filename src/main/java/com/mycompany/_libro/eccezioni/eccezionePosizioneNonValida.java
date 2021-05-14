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
public class eccezionePosizioneNonValida extends Exception
{
    private int posizione;

    public eccezionePosizioneNonValida(int posizione)
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
        s+="Posizione: "+getPosizione()+" non è valida.";
        return s;
    }
    
}
