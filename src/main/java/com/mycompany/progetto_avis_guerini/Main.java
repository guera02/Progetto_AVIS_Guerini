/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

import com.mycompany._libro.eccezioni.FileException;
import com.mycompany._libro.eccezioni.eccezionePosizioneNonValida;
import com.mycompany._libro.eccezioni.eccezionePosizioneVuota;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stocc
 */
public class Main implements Serializable
{
    public static void main(String[] args) 
    {
        
        String[] vociMenu=new String[8];
        int sceltaUtente=-1;
        final int N_MAX_DONATORI=100;
        int giorno,mese,anno,posizione,nDonazioniEffettuate;
        Donatore d;
        Donatore[] elencoDonatori=new Donatore[N_MAX_DONATORI];
        LocalDate dataDiNascita;
        AVIS a=new AVIS();
        
        Scanner tastiera=new Scanner(System.in);
        
        String nomeFile="donatori.txt";
        String nomeFileBinario="elencoDonatori.bin";
        
        vociMenu[0]="Esci dal programma";
        vociMenu[1]="Aggiungi un donatore";
        vociMenu[2]="Elimina un donatore";
        vociMenu[3]="Effettua una donazione";
        vociMenu[4]="Visualizza i donatori in ordine alfabetico";
        vociMenu[5]="Visualizza tutti i donatori che abbiano svolto almeno un tot di donazioni";
        vociMenu[6]="Esporta donatori in un file CSV";
        vociMenu[7]="Salva i donatori su un file binario";
        
        Menu menu=new Menu(vociMenu);
        
        do
        {
            
            sceltaUtente=menu.sceltaMenu();
            switch(sceltaUtente)
            {
                case 0:
                {
                    System.out.println("L'applicazione verrà terminata a breve...");
                    break;
                }
                case 1: //aggiunta di un donatore
                {
                    d=new Donatore();
                      
                    //tastiera.nextLine();
                    
                    System.out.println("Inserisci il cognome del donatore:");
                    d.setCognome(tastiera.nextLine());
                    System.out.println("Inserisci il nome del donatore:");
                    d.setNome(tastiera.nextLine());
                    System.out.println("Inserisci il giorno di nascita del donatore:");
                    giorno=tastiera.nextInt();
                    System.out.println("Inserisci il mese di nascita del donatore:");
                    mese=tastiera.nextInt();
                    System.out.println("Inserisci l'anno di nascita del donatore:");
                    anno=tastiera.nextInt();
                    dataDiNascita=LocalDate.of(anno, mese, giorno);
                    d.setDataDiNascita(dataDiNascita);
                    
                    a.aggiungiDonatore(d);
                    
                    System.out.println("Inserimento avvenuto correttamente!\n");
                    tastiera.nextLine();
                    
                    break;
                }
                case 2: //eliminazione di un donatore
                {
                    System.out.println("Inserisci il codice identificativo del donatore che si vuole eliminare: ");
                    posizione=tastiera.nextInt();
                    
                    try 
                    {
                        a.eliminaDonatore(posizione);
                        System.out.println("Eliminazione avvenuta con successo!");
                    } 
                    catch (eccezionePosizioneNonValida ex) 
                    {
                        System.out.println(ex.toString());
                    } 
                    catch (eccezionePosizioneVuota ex)
                    {
                        System.out.println(ex.toString());
                    }
                    
                    tastiera.nextLine();
                    
                    System.out.println("Premere un pulsante per continuare...");
                    tastiera.nextLine();
                    break;
                }
                case 3: //effettuare una donazione
                {
                    System.out.println("Inserisci il codice identificativo del donatore di cui si vuole effettuare una donazione: ");
                    posizione=tastiera.nextInt();
                    
                    try
                    {
                        a.aggiungiDonazione(posizione);
                        System.out.println("Operazione avvenuta correttamente!");
                    }
                    catch(eccezionePosizioneNonValida e1)
                    {
                        System.out.println(e1.toString());
                    }
                    catch(NullPointerException e2)
                    {
                        System.out.println("In posizione "+posizione+" non c'è nulla.");
                    }
                    
                    tastiera.nextLine();
                    
                    System.out.println("Premere un pulsante per continuare...");
                    tastiera.nextLine();
                    break;
                }
                case 4: //visualizza donatori in ordine alfabetico
                {
                    try
                    {
                        elencoDonatori=a.visualizzaDonatoriOrdineAlfabetico();
                        for(int i=0;i<N_MAX_DONATORI;i++)
                        {
                           System.out.println(elencoDonatori[i].toString());
                        }
                    }
                    catch(NullPointerException e1)
                    {
                        
                    }
                    
                    System.out.println("\nPremere un pulsante per continuare...");
                    tastiera.nextLine();
                    break;
                }
                case 5: //visualizza donatori in base a un numero minimo di donazioni effettuate
                {
                    System.out.println("Inserisci il numero minimo di donazioni che soddisfano il requisito: ");
                    nDonazioniEffettuate=tastiera.nextInt();
                    a.visualizzaDonatoriNDonazioniEffettuate(nDonazioniEffettuate);
                    
                    System.out.println("\nPremere un pulsante per continuare...");
                    tastiera.nextLine();
                    break;
                }
                case 6: //esporta donatori in formato CSV
                {
                    try 
                    {
                        a.esportaLibriCSV(nomeFile);
                        System.out.println("Salvataggio avvenuto correttamente!");
                    }
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile accedere al file: i donatori non sono stati salvati.");
                    }
                    catch (eccezionePosizioneNonValida | FileException ex) 
                    {
                        System.out.println(ex.toString());
                    } 
                    
                    System.out.println("\nPremere un pulsante per continuare...");
                    tastiera.nextLine();
                    break;
                }
                case 7: //salva donatori in file binario
                {
                    try 
                    {
                        a.salvaDonatori(nomeFileBinario);
                        System.out.println("Salvataggio avvenuto correttamente!");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile accedere al file: i donatori non sono stati salvati.");
                    }
                    
                    System.out.println("\nPremere un pulsante per continuare...");
                    tastiera.nextLine();
                    break;
                }
            }
            
        }while(sceltaUtente!=0);
        
    }
}
