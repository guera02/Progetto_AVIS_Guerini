/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

import com.mycompany.progetto_avis_guerini.eccezioni.eccezionePosizioneVuota;
import com.mycompany.progetto_avis_guerini.eccezioni.eccezionePosizioneNonValida;
import com.mycompany.progetto_avis_guerini.eccezioni.FileException;
import com.mycompany.progetto_avis_guerini.eccezioni.eccezioneAVISvuota;
import com.mycompany.progetto_avis_guerini.file.TextFile;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Classe che permette di istanziare un'associazione AVIS, che contiene 
 * tutti i donatori presenti.<br>
 * La classe AVIS ha 2 attributi che sono:<br>
 * <b>elencoDonatori</b>, un array di donatori;<br>
 * <b>N_MAX_DONATORI</b>, il numero massimo di donatori che può contenere l'AVIS: di default
 * il numero massimo è impostato a 100.
 * @author Guerini
 * @version 1.0
 */
public class AVIS implements Serializable
{
    private Donatore[] elencoDonatori;
    private final int N_MAX_DONATORI=100;
    
    /**
     * Metodo costruttore della classe AVIS, che istanzia l'array di donatori.
     */
    public AVIS()
    {
        elencoDonatori=new Donatore[N_MAX_DONATORI];
    }
    
    public void setDonatore(Donatore d, int posizione)
    {
        if(elencoDonatori[posizione]==null)
            elencoDonatori[posizione]=new Donatore(d);
    }
    
    /**
     * Metodo che restituisce il donatore in una posizione nell'array.
     * @param posizione la posizione in cui si trova il donatore desiderato.
     * @return il donatore prescelto.
     */
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
    
    /**
     * Metodo che permette di aggiungere un donatore all'AVIS.
     * @param d il donatore che si vuole aggiungere.
     */
    public void aggiungiDonatore(Donatore d) throws ArrayIndexOutOfBoundsException
    {
        int n=0;
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori[i]==null)
            {
                n++;
                d.setNumeroTessera(i);
                elencoDonatori[i]=new Donatore(d);
                break;
            }     
        }
        
        if(n==N_MAX_DONATORI)
            throw new ArrayIndexOutOfBoundsException();
    }
    
    /**
     * Metodo che, sapendo una posizione nota, va a cercare se nell'array elencoDonatori
     * è presente un donatore ed eventualmente procederà all'eliminazione di
     * quest'ultimo.
     * @param posizione la posizione del donatore che si intende eliminare.
     */
    public void eliminaDonatore(int posizione) throws eccezionePosizioneNonValida, eccezionePosizioneVuota
    {
        if(elencoDonatori[posizione]!=null)
            elencoDonatori[posizione]=null;
        else
            throw new eccezionePosizioneVuota(posizione);
    }
    
    /**
     * Metodo che, sapendo la posizione del donatore, va ad aggiungere una donazione,
     *  incrementando la variabile nDonazioniEffettuate e visualizzando i dati del 
     * donatore che ha effettuato la donazione.<br>
     * @param posizione la posizione del donatore cui si intende voler fare una
     * donazione.<br>
     */
    public void aggiungiDonazione(int posizione) throws eccezionePosizioneNonValida
    {
        int n;
        Donatore d;
        
        for(int i=posizione;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori[posizione].getCognome()=="")
                break;
            else
            {
                n=elencoDonatori[posizione].getNDonazioniEffettuate();
                d=elencoDonatori[posizione];
                n++;
                elencoDonatori[posizione].setNDonazioniEffettuate(n);
                System.out.println(d.toString());
                break;
            }
        }
    }
    
    /**
     * Metodo che permette di visualizzare i donatori in base ad un numero
     * minimo di nDonazioniEffettuate. Perciò, se il numero minimo passato per
     * parametro è 2, metterà a schermo tutti i donatori che hanno svolto <b>almeno</b>
     * 2 donazioni.<br>
     * @param n il numero minimo di donazioni per soddisfare il requisito.
     */
    public void visualizzaDonatoriNDonazioniEffettuate(int n) throws eccezioneAVISvuota
    {
        int t=0;
        
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori[i]==null)
                break;
            else
            {
                if(elencoDonatori[i].getNDonazioniEffettuate()>=n)
                {
                    System.out.println(elencoDonatori[i].toString());
                    t++;
                }       
            }
        }
        if(t==0)
            throw new eccezioneAVISvuota("Nessun donatore con "+n+" donazioni effettuate.");
    }
    
    /**
     * Metodo che permette di visualizzare tutti i donatori presenti all'interno
     * dell'AVIS in ordine alfabetico, prima in base al cognome, e poi in base al
     * nome.<br>
     * @return un array di donatori ordinati in ordine alfabetico.
     */
    public Donatore[] visualizzaDonatoriOrdineAlfabetico() throws eccezioneAVISvuota
    {
        Donatore[] copia=new Donatore[elencoDonatori.length];
        Donatore d;
        int c=0;
        int n=0;
        
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            d=getDonatore(i);
            if(d.getCognome()=="")
            {
                n++;
            }
            else
            {
                copia[c]=d;
                c++;
            }
        }
        
        if(n==100)
            throw new eccezioneAVISvuota("Nessun donatore presente.");
        copia=Ordinatore.selectionSortAlfabeticoCognomeNome(copia);
        return copia;
    }
    
    /**
     * Metodo che consente di esportare i donatori di un'associazione AVIS in
     * formato CSV.
     * @param nomeFile il nome del file di testo.<br>
     */
    public void esportaInCSV(String nomeFile) throws IOException, eccezionePosizioneNonValida, FileException, eccezioneAVISvuota
    {
        TextFile f1=new TextFile(nomeFile, 'w');
        Donatore d;
        int n=0;
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            d=getDonatore(i);
            if(d.getCognome()!="")
                    f1.toFile(i+";"+d.getCognome()+";"+d.getNome()+";"+d.getDataDiNascita()+";"+d.getNDonazioniEffettuate()+";");
            else
                n++;
        }
        if(n==N_MAX_DONATORI)
            throw new eccezioneAVISvuota("Nessun donatore presente: impossibile esportare.");
        f1.close();
    }
    
    /**
     * Metodo che permette di salvare i donatori su un file binario.
     * @param nomeFile il nome del file binario.<br>
     */
    public void salvaDonatori(String nomeFile) throws IOException, eccezioneAVISvuota
    {
        int n=0;
        for(int i=0;i<N_MAX_DONATORI;i++)
        {
            if(elencoDonatori[i]==null)
                n++;
        }
        if(n==N_MAX_DONATORI)
            throw new eccezioneAVISvuota("Nessun donatore presente: impossibile salvare i donatori.");
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);

        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
    /**
     * Metodo che permette di leggere dal file binario i donatori e caricarli
     * all'avvio dell'applicazione.
     * @param nomeFile il nome del file binario.<br>
     * @return l'associazione AVIS.<br>
     */
    public AVIS caricaDonatori(String nomeFile) throws IOException, FileException
    {
        AVIS a;
        FileInputStream f1=new FileInputStream(nomeFile);
        ObjectInputStream reader=new ObjectInputStream(f1);

        try 
        {
            a=(AVIS)reader.readObject();
            reader.close();
            return a;
        } 
        catch (ClassNotFoundException ex) 
        {
            reader.close();
            throw new FileException("Errore di lettura");
        }   
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
