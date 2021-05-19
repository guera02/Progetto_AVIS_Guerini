/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

import java.util.Scanner;

/**
 *
 * @author stocc
 */
public class Menu 
{
    private String[] elencoVoci;
    private int numeroVoci;
    
    public Menu(String[] elencoVoci)
    {
        numeroVoci=elencoVoci.length;
        this.elencoVoci=new String[numeroVoci];
        for(int i=0;i<numeroVoci;i++)
            this.elencoVoci[i]=elencoVoci[i];
    }
    
    public void visualizzaMenu()
    {
        System.out.println("Menù: ");
        for(int i=0;i<numeroVoci;i++)
        {
            System.out.println(i+" --> "+elencoVoci[i]);
        }
    }
    
    public int sceltaMenu()
    {
        Scanner tastiera=new Scanner(System.in);
        String inputUtente;
        boolean inputUtenteOk=true;
        int sceltaUtente=0;
        
        do
        {
            visualizzaMenu();
            System.out.println("Scelta --> ");
            inputUtente=tastiera.nextLine();
        
            inputUtenteOk=true;
            for(int i=0;i<inputUtente.length();i++)
            {
                if(inputUtente.charAt(i)>='0' && inputUtente.charAt(i)<='9')
                    i++;
                else
                {
                    inputUtenteOk=false;
                    break;
                }   
                
            }
        
            if(inputUtenteOk)
            {
                sceltaUtente=Integer.parseInt(inputUtente);
                if(sceltaUtente<0 || sceltaUtente>numeroVoci-1)
                    inputUtenteOk=false;
            }
        
            if(!inputUtenteOk)
            {
                System.out.println("Il valore inserito non è valido. Premi invio ed inserisci nuovamente la tua scelta");
                tastiera.nextLine();
            }
        }while(!inputUtenteOk);
        
        return sceltaUtente;
    }
}
