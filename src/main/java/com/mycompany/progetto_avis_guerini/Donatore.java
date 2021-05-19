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
 *
 * @author Guerini
 */

public class Donatore implements Serializable
{
    //attributi
    private int numeroTessera;
    private String cognome;
    private String nome;
    private LocalDate dataDiNascita;
    private int nDonazioniEffettuate;
    
    public Donatore(int numeroTessera, String cognome, String nome, int anno, int mese, int giorno)
    {
        this.numeroTessera=numeroTessera;
        this.cognome=cognome;
        this.nome=nome;
        dataDiNascita=LocalDate.of(anno, mese, giorno);
        nDonazioniEffettuate=0;
    }

    public Donatore(Donatore d)
    {
        numeroTessera=d.getNumeroTessera();
        cognome=d.getCognome();
        nome=d.getNome();
        dataDiNascita=d.getDataDiNascita();
        nDonazioniEffettuate=d.getnDonazioniEffettuate();
    }
    
    public Donatore()
    {
        numeroTessera=0;
        cognome="";
        nome="";
        dataDiNascita=null;
        nDonazioniEffettuate=0;
    }
    
    public int getNumeroTessera() 
    {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) 
    {
        this.numeroTessera = numeroTessera;
    }

    public String getCognome() 
    {
        return cognome;
    }

    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public LocalDate getDataDiNascita() 
    {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) 
    {
        this.dataDiNascita = dataDiNascita;
    }

    public int getnDonazioniEffettuate() 
    {
        return nDonazioniEffettuate;
    }

    public void setnDonazioniEffettuate(int nDonazioniEffettuate) 
    {
        this.nDonazioniEffettuate = nDonazioniEffettuate;
    }

    @Override
    public String toString() 
    {
        return "Donatore{" + "numeroTessera=" + numeroTessera + ", cognome=" + cognome + ", nome=" + nome + ", dataDiNascita=" + dataDiNascita + ", nDonazioniEffettuate=" + nDonazioniEffettuate + '}';
    }
    
    
}
