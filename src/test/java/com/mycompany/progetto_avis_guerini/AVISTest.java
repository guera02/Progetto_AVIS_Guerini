/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author stocc
 */
public class AVISTest 
{
    Donatore[] elencoAtteso;
    Donatore[] elencoDonatoriTest;
    Donatore d1;
    Donatore d2;
    AVIS test;
    AVIS test1;
    
    @Before
    public void Inizializzazione()
    {
        elencoAtteso=new Donatore[100];
        elencoDonatoriTest=new Donatore[100];
        d1=new Donatore(0, "Guerini", "Angelo", 2002, 6, 6);
        d2=new Donatore(1, "Angelo", "Guerini", 2006, 4, 2);
        test=new AVIS();
        test1=new AVIS();
    }
    /**
     * Test of getDonatore method, of class AVIS.
     */
    @org.junit.Test
    public void testGetDonatore() 
    {
        Donatore atteso=d1;
        test.setDonatore(atteso, 0);
        
        Donatore attuale=test.getDonatore(0);
        
        assertEquals("Donatore in posizione 0: ", atteso, attuale);
    }

    /**
     * Test of aggiungiDonatore method, of class AVIS.
     */
    @org.junit.Test
    public void testAggiungiDonatore() 
    {
        Donatore atteso=d1;
        
        test.aggiungiDonatore(d1);
        Donatore attuale=test.getDonatore(0);
        
        assertEquals("Test aggiunta donatore: ", atteso, attuale);
    }

    /**
     * Test of eliminaDonatore method, of class AVIS.
     */
    @org.junit.Test
    public void testEliminaDonatore() throws Exception 
    {
        Donatore atteso=new Donatore();
        
        test.setDonatore(d1, 0);
        test.eliminaDonatore(0);
        
        Donatore attuale=test.getDonatore(0);
        
        assertEquals("Test eliminazione donatore: ", atteso, attuale);
    }

    /**
     * Test of aggiungiDonazione method, of class AVIS.
     */
    @org.junit.Test
    public void testAggiungiDonazione() throws Exception 
    {
        d1.setNDonazioniEffettuate(1);
        Donatore atteso=d1;
        
        Donatore d3=new Donatore(d1);
        d3.setNDonazioniEffettuate(0);
        test.setDonatore(d3, 0);
        test.aggiungiDonazione(0);
        
        Donatore attuale=test.getDonatore(0);
        
        assertEquals("Test aggiunta donazione: ", atteso, attuale);
    }
    
}
