/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jonas
 */
@Local
public interface StatelessBeanLocal 
{
    public int getBNumer(int pnummer);
    public int getWerkType(int pnummer);
    public List getOnkosten(int pnummer);
    public int getOnkostId(int pnummer);
    public List getKredietenAll();
    public Onkosten getOnkostById(int onkostId);
    public List getKredietenEigenEnBaas(int pnummer, int bnummer);
    public void setNegatief(int krNummer, int getal);
    public void setOnkostStatus(int onkostId, String status);
    public Kredieten getKredietById(int krNummer);
    public void setKredietSaldo(int krNummer, double saldo);
    public void setOnkost(int onkostId, String omschrijving, Date datum, double onkBedrag, String status);
    public void deleteOnkost(int onkostId);
    public void maakNewOnkost(int onkId, String omsch, Date d, double onkBed, String stat, int pnr);
}
