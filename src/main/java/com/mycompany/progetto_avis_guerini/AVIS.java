/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

import com.mycompany._libro.eccezioni.*;

/**
 *
 * @author stocc
 */
public class AVIS 
{
    private Donatore[] elencoDonatori;
    private final int N_MAX_DONATORI=100;
    
    public AVIS()
    {
        elencoDonatori=new Donatore[N_MAX_DONATORI];
    }
    
    public void aggiungiDonatore(Donatore d) throws ArrayIndexOutOfBoundsException
    {
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori!=null)
            {
                elencoDonatori[i]=new Donatore(d);
                break;
            }     
        }
    }
    
    public void eliminaDonatore(int posizione) throws eccezionePosizioneNonValida, eccezionePosizioneVuota
    {
            if(elencoDonatori[posizione]!=null)
                elencoDonatori[posizione]=null;
    }

/*    @Override
   public String toString() 
    {
        String s="";
        Donatore d;
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori[i]==null)
                break;
            else
            {
                d=elencoDonatori[i];
                s+="Posizione: "+i+" "+d.toString()+"\n";
            }     
        }
        return s;
    }*/
    
    
}
