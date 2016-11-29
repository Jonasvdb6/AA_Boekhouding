/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author jonas
 */
public class Krediet 
{
    
    private int krNummer;
    private double krSaldo;
    private int krType; // 1 => gewoon krediet ; 2 => gewaarborgd krediet
    
    public Krediet()
    {
        
    }

    public int getKrNummer() {
        return krNummer;
    }

    public void setKrNummer(int krNummer) {
        this.krNummer = krNummer;
    }

    public double getKrSaldo() {
        return krSaldo;
    }

    public void setKrSaldo(double krSaldo) {
        this.krSaldo = krSaldo;
    }

    public int getKrType() {
        return krType;
    }

    public void setKrType(int krType) {
        this.krType = krType;
    }
}