/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

/**
 *
 * @author stocc
 */
public class Ordinatore 
{
    
    public static void scambia(Donatore[] v, int posizione1, int posizione2)
    {
        Donatore c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static void scambia(String v[], int posizione1, int posizione2)
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static Donatore[] selectionSortAlfabeticoCognomeNome(Donatore[] a)
    {
        Donatore[] ordinato= new Donatore[a.length];
        for(int i=0;i<a.length;i++)
            ordinato[i]=a[i];
        
        for(int i=0; i<=ordinato.length-2;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]==null)
                    break;
                if(ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())<0 || (ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())==0 && ordinato[j].getNome().compareToIgnoreCase(ordinato[i].getNome())<0))
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;    
    }
}
