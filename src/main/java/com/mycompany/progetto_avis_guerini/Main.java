/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

import com.mycompany.progetto_avis_guerini.eccezioni.FileException;
import com.mycompany.progetto_avis_guerini.eccezioni.eccezioneAVISvuota;
import com.mycompany.progetto_avis_guerini.eccezioni.eccezioneCognomeNome;
import com.mycompany.progetto_avis_guerini.eccezioni.eccezionePosizioneNonValida;
import com.mycompany.progetto_avis_guerini.eccezioni.eccezionePosizioneVuota;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Guerini
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
        Donatore d1=new Donatore(5, "Peppino", "Giuseppini", 2003, 6, 8);
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
        
        try
        {
            a=a.caricaDonatori(nomeFileBinario);
            System.out.println("Caricamento avvenuto correttamente!");
        }
        catch(IOException | FileException e1)
        {
            System.out.println("Impossibile accedere al file: i donatori non sono stati caricati.");
        }
        
        Menu menu=new Menu(vociMenu);
        
        do
        {
            try
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
                        try
                        {
                            System.out.println("Inserisci il cognome del donatore:");
                            d.setCognome(tastiera.nextLine());
                            System.out.println("Inserisci il nome del donatore:");
                            d.setNome(tastiera.nextLine());
                        }
                        catch(eccezioneCognomeNome e1)
                        {
                            System.out.println(e1.toString());
                            System.out.println("\nPremi un pulsante per continuare...");
                            tastiera.nextLine();
                            break;
                        }
                        
                        System.out.println("Inserisci il giorno di nascita del donatore:");
                        giorno=tastiera.nextInt();
                        System.out.println("Inserisci il mese di nascita del donatore:");
                        mese=tastiera.nextInt();
                        System.out.println("Inserisci l'anno di nascita del donatore:");
                        anno=tastiera.nextInt();
                        dataDiNascita=LocalDate.of(anno, mese, giorno);
                        d.setDataDiNascita(dataDiNascita);

                        try
                        {
                            a.aggiungiDonatore(d);
                        }
                        catch(ArrayIndexOutOfBoundsException e1)
                        {
                            System.out.println("Raggiunto il massimo numero di donatori disponibili...");
                            System.out.println("\nPremi un pulsante per continuare...");
                            tastiera.nextLine();
                            break;
                        }

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
                        catch(ArrayIndexOutOfBoundsException ex)
                        {
                            System.out.println("Posizione fuori dai limiti massimi!");
                            System.out.println("\nPremi un pulsante per continuare...");
                            tastiera.nextLine();
                            break;
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
                        if(posizione>N_MAX_DONATORI)
                        {
                            System.out.println("Il numero "+posizione+" non è valido.");
                            tastiera.nextLine();
                            System.out.println("Premere un pulsante per continuare...");
                            tastiera.nextLine();
                            break;
                        }
             
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
                        catch(eccezioneAVISvuota e2)
                        {
                            System.out.println(e2.toString());
                        }

                        System.out.println("\nPremere un pulsante per continuare...");
                        tastiera.nextLine();
                        break;
                    }
                    case 5: //visualizza donatori in base a un numero minimo di donazioni effettuate
                    {
                        System.out.println("Inserisci il numero minimo di donazioni che soddisfano il requisito: ");
                        nDonazioniEffettuate=tastiera.nextInt();
                        try
                        {
                            a.visualizzaDonatoriNDonazioniEffettuate(nDonazioniEffettuate);
                        }
                        catch(eccezioneAVISvuota e1)
                        {
                            System.out.println(e1.toString());
                        }

                        tastiera.nextLine();
                        System.out.println("\nPremere un pulsante per continuare...");
                        tastiera.nextLine();
                        break;
                    }
                    case 6: //esporta donatori in formato CSV
                    {
                        try 
                        {
                            a.esportaInCSV(nomeFile);
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
                        catch(eccezioneAVISvuota e1)
                        {
                            System.out.println(e1.toString());
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
                        catch(eccezioneAVISvuota e1)
                        {
                            System.out.println(e1.toString());
                        }

                        
                        System.out.println("\nPremere un pulsante per continuare...");
                        tastiera.nextLine();
                        break;
                    }
                }
            }
            catch(InputMismatchException | NumberFormatException e2)
            {
                tastiera.nextLine();
                System.out.println("Input non corretto... Ritorno al menù principale!");
                tastiera.nextLine();
            }
        }while(sceltaUtente!=0);
        
    }
}
