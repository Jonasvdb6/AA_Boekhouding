package Data;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonas
 */
public class Werknemers 
{
    
    private int pNummer; //persoonsnummer
    private String pswd;
    private int werkType; // 1 => gewone werknemer ; 2 => manager ; 3 => boekhouder
    private ArrayList onkosten = new ArrayList();
    private ArrayList kredieten = new ArrayList();
    private int bNummer; //baasnummer
    
    
    public double getOnkost(int i)
    {
        return (double) onkosten.get(i);
    }
    
    public ArrayList getOnkosten()
    {
        return onkosten;
    }

    public void setOnkost(int i, double onkost) {
        onkosten.set(i, onkost);
    }
    
    public double getKrediet(int i)
    {
        return (double) kredieten.get(i);
    }
    
    public ArrayList getKredieten()
    {
        return kredieten;
    }
    
    public void setKrediet(int i, double krediet)
    {
        kredieten.set(i, krediet);
    }

    public int getpNummer() {
        return pNummer;
    }

    public void setpNummer(int pNr) {
        pNummer = pNr;
    }

    public int getbNummer() {
        return bNummer;
    }

    public void setbNummer(int bNr) {
        bNummer = bNr;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String psw) {
        pswd = psw;
    }

    public int getWerkType() {
        return werkType;
    }

    public void setWerkType(int type) {
        werkType = type;
    }
}