/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

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
        Donatore d1=new Donatore();
        AVIS a=new AVIS();
        String cognome,nome;
        int anno,mese,giorno;
        LocalDate dataDiNascita;
        
        Scanner tastiera=new Scanner(System.in);
        
        System.out.println(d1.toString());
        
        d1.setNumeroTessera(0);
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
        
        d1.setnDonazioniEffettuate(0);
        
        a.aggiungiDonatore(d1);
        
        System.out.println(a.toString());
    }
}
