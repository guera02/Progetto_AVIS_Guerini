/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

import com.mycompany._libro.eccezioni.*;
import com.mycompany.progetto_avis_guerini.file.TextFile;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author stocc
 */
public class AVIS implements Serializable
{
    private Donatore[] elencoDonatori;
    private final int N_MAX_DONATORI=100;
    
    public AVIS()
    {
        elencoDonatori=new Donatore[N_MAX_DONATORI];
    }
    
    public Donatore getDonatore(int posizione)
    {
        Donatore d=new Donatore();
        for(int i=posizione;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori[i]!=null)
            {
                d=elencoDonatori[i];
                return d;
            }
            else
                break;
        }
        return d;
    }
    
    public void aggiungiDonatore(Donatore d) throws ArrayIndexOutOfBoundsException
    {
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori[i]==null)
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
    
    public void aggiungiDonazione(int posizione)
    {
        int n;
        Donatore d;
        
        for(int i=posizione;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori[posizione]==null)
                break;
            else
            {
                n=elencoDonatori[posizione].getnDonazioniEffettuate();
                d=elencoDonatori[posizione];
                n++;
                elencoDonatori[posizione].setnDonazioniEffettuate(n);
                System.out.println(d.toString());
                break;
            }
        }
    }
    
    public void visualizzaDonatoriNDonazioniEffettuate(int n)
    {
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori[i]==null)
                break;
            else
            {
                if(elencoDonatori[i].getnDonazioniEffettuate()>=n)
                    System.out.println(elencoDonatori[i].toString());
            }
        }
    }
    
    public Donatore[] visualizzaDonatoriOrdineAlfabetico() throws eccezionePosizioneNonValida
    {
        Donatore[] copia=new Donatore[elencoDonatori.length];
        Donatore d;
        int c=0;
        
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            d=getDonatore(i);
            if(d.getCognome()!="")
            {
                copia[c]=d;
                c++;
            }
        }
        
        copia=Ordinatore.selectionSortAlfabeticoCognomeNome(copia);
        return copia;
    }
    
    public void esportaLibriCSV(String nomeFile) throws IOException, eccezionePosizioneNonValida, FileException
    {
        TextFile f1=new TextFile(nomeFile, 'w');
        Donatore d;
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            d=getDonatore(i);
            if(d.getCognome()!="")
                    f1.toFile(i+";"+d.getCognome()+";"+d.getNome()+";"+d.getDataDiNascita()+";"+d.getnDonazioniEffettuate()+";");
        }
        f1.close();
    }
    
    @Override
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
    }
    
    
}
