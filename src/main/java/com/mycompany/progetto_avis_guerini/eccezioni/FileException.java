/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_avis_guerini.eccezioni;

/**
 *
 * @author stocc
 */
public class FileException extends Exception 
{
    
    private String messaggio;
    
    public FileException(String m) 
    {
        this.messaggio=m;
    }

    @Override
    public String toString() 
    {
        return messaggio;
    }
    
    
    
}
