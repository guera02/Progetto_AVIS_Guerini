/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

/**
 * Classe che permette di istanziare e di gestire un donatore.<br>
 * <b>Donatore</b> che come parametri ha:<br>
 * <b>numeroTessera</b>, il numero della tessera di un donatore;<br>
 * <b>cognome</b>, il cognome del donatore;<br>
 * <b>nome</b>, il nome del donatore;<br>
 * <b>dataDiNascita</b>, la data di nascita del donatore;<br>
 * <b>nDonazioniEffettuate</b>, il numero di donazioni effettuate dal donatore.<br>
 * @author Guerini
 * @version 1.0
 */

public class Donatore implements Serializable
{
    //attributi
    private int numeroTessera;
    private String cognome;
    private String nome;
    private LocalDate dataDiNascita;
    private int nDonazioniEffettuate;
    
    /**
     * Questo metodo consente di istanziare un oggetto di tipo Donatore conoscendo:
     * @param numeroTessera il numero della tessera del donatore;
     * @param cognome il cognome del donatore;
     * @param nome il nome del donatore;
     * @param anno l'anno di nascita del donatore;
     * @param mese il mese di nascita del donatore;
     * @param giorno il giorno di nascita del donatore.
     */
    
    public Donatore(int numeroTessera, String cognome, String nome, int anno, int mese, int giorno)
    {
        this.numeroTessera=numeroTessera;
        this.cognome=cognome;
        this.nome=nome;
        dataDiNascita=LocalDate.of(anno, mese, giorno);
        nDonazioniEffettuate=0;
    }

    /**
     * Questo metodo permette di istanziare una copia di un donatore già esistente.
     * @param d il donatore di cui si intende effettuare una copia.
     */
    public Donatore(Donatore d)
    {
        numeroTessera=d.getNumeroTessera();
        cognome=d.getCognome();
        nome=d.getNome();
        dataDiNascita=d.getDataDiNascita();
        nDonazioniEffettuate=d.getNDonazioniEffettuate();
    }
    
    /**
     * Metodo costruttore di default della classe Donatore.
     */
    public Donatore()
    {
        numeroTessera=0;
        cognome="";
        nome="";
        dataDiNascita=null;
        nDonazioniEffettuate=0;
    }
    
    /**
     * Metodo che serve a restituire il numeroTessera di uno specifico donatore.
     * @return numeroTessera del donatore.
     */
    public int getNumeroTessera() 
    {
        return numeroTessera;
    }

    /**
     * Metodo per impostare il valore numeroTessera ad uno specifico donatore.
     * @param numeroTessera il numero della tessera che bisognerà attribuire
     * al donatore desiderato.
     */
    public void setNumeroTessera(int numeroTessera) 
    {
        this.numeroTessera = numeroTessera;
    }

    /**
     * Metodo che consente di ottenere il cognome di uno specifico donatore.
     * @return il cognome del donatore.
     */
    public String getCognome() 
    {
        return cognome;
    }

    /**
     * Metodo che serve per assegnare il cognome di un donatore.
     * @param cognome il cognome che si vuole attribuire ad uno specifico donatore.
     */
    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    /**
     * Metodo per restituire il nome di un donatore.
     * @return il nome del donatore scelto.
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * Metodo che consente di assegnare un nome ad uno specifico donatore.
     * @param nome il nome che si vuole attribuire al donatore scelto.
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    /**
     * Metodo che consente di restituire la data di nascita del donatore.
     * @return la data di nascita.
     */
    public LocalDate getDataDiNascita() 
    {
        return dataDiNascita;
    }

    /**
     * Metodo per assegnare la data di nascita di un donatore specifico.
     * @param dataDiNascita la data di nascita che si vuole attribuire.
     */
    public void setDataDiNascita(LocalDate dataDiNascita) 
    {
        this.dataDiNascita = dataDiNascita;
    }

    /**
     * Metodo per restituire il numero di donazioni effettuate da uno specifico donatore.
     * @return nDonazioniEffettuate da un donatore.
     */
    public int getNDonazioniEffettuate() 
    {
        return nDonazioniEffettuate;
    }

    /**
     * Metodo che consente di assegnare nDonazioniEffettuate da parte di un donatore.
     * @param nDonazioniEffettuate il numero di donazioni che si vuole attribuire ad un donatore.
     */
    public void setNDonazioniEffettuate(int nDonazioniEffettuate) 
    {
        this.nDonazioniEffettuate = nDonazioniEffettuate;
    }

    @Override
    public String toString() 
    {
        return "Donatore{" + "numeroTessera=" + numeroTessera + ", cognome=" + cognome + ", nome=" + nome + ", dataDiNascita=" + dataDiNascita + ", nDonazioniEffettuate=" + nDonazioniEffettuate + '}';
    }
    
    
}
