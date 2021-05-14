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
public class eccezionePosizioneNonVuota extends Exception
{
    private int ripiano;
    private int posizione;

    public eccezionePosizioneNonVuota(int ripiano, int posizione)
    {
        this.ripiano=ripiano;
        this.posizione=posizione;
    }
    
    public int getRipiano() 
    {
        return ripiano;
    }

    public int getPosizione() 
    {
        return posizione;
    }
    
    public String toString()
    {
        String s="";
        s+="La posizione: Ripiano "+getRipiano()+";Posizione: "+getPosizione()+" non è vuota.";
        return s;
    }
    
}
