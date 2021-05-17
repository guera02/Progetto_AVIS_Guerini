/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

import com.mycompany._libro.eccezioni.FileException;
import com.mycompany._libro.eccezioni.eccezionePosizioneNonValida;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author stocc
 */
public class Main 
{
    public static void main(String[] args) 
    {
        Donatore d1=new Donatore(0, "Guerini", "Angelo", 2002, 6, 6);
        Donatore d2=new Donatore(1, "Guerini", "Abba", 2007, 4, 5);
        Donatore d3=new Donatore(2, "Vaffanculo", "Ciao", 2009, 1, 3);
        d1.setnDonazioniEffettuate(4);
        d2.setnDonazioniEffettuate(10);
        d3.setnDonazioniEffettuate(2);
        
        AVIS a=new AVIS();
        String cognome,nome;
        int anno,mese,giorno;
        LocalDate dataDiNascita;
        
        String nomeFile="donatori.txt";
        
        a.aggiungiDonatore(d1);
        a.aggiungiDonatore(d2);
        a.aggiungiDonatore(d3);
        
        Scanner tastiera=new Scanner(System.in);
        
        /*d1.setNumeroTessera(0);
        System.out.println("Inserisci il cognome del donatore: ");
        cognome=tastiera.nextLine();
        d1.setCognome(cognome);
        
        System.out.println("Inserisci il nome del donatore: ");
        nome=tastiera.nextLine();
        d1.setNome(nome);
        
        System.out.println("Inserisci l'anno di nascita del donatore: ");
        anno=tastiera.nextInt();
        System.out.println("Inserisci il mese di nascita del donatore: ");
        mese=tastiera.nextInt();
        System.out.println("Inserisci il giorno di nascita del donatore: ");
        giorno=tastiera.nextInt();
        
        dataDiNascita=LocalDate.of(anno,mese,giorno);
        d1.setDataDiNascita(dataDiNascita);
        
        d1.setnDonazioniEffettuate(0);*/
        
        //a.visualizzaDonatoriNDonazioniEffettuate(4);
        
        /*Donatore[] elencoDiCopia;
        try
        {
            elencoDiCopia=a.visualizzaDonatoriOrdineAlfabetico();
            for(int i=0;i<elencoDiCopia.length;i++)
            {
                if(elencoDiCopia[i]!=null)
                    System.out.println(elencoDiCopia[i].toString());
            }               
        }
        catch(eccezionePosizioneNonValida e1)
        {
            System.out.println(e1.toString());
        }*/
        
        try
        {
            a.esportaLibriCSV(nomeFile);
            System.out.println("Donatori esportati correttamente.");
        }
        catch(IOException e1)
        {
            System.out.println("Impossibile accedere al file: i libri non sono stati salvati.");
        }
        catch(eccezionePosizioneNonValida | FileException e2)
        {
            System.out.println(e2.toString());
        }
        
    }
}
