/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonas
 */
@Stateless
public class StatelessBean implements StatelessBeanLocal 
{
    
    @PersistenceContext
    private EntityManager em;
    
/*  *** Werknemers ***  */
    public int getBNumer(int pnummer)
    {
        Werknemers w = em.find (Werknemers.class, pnummer);
        //Zelfde resultaat op een andere manier:
        //Werknemers w = (Werknemers) em.createNamedQuery("Werknemers.findByPNummer").setParameter("pNummer", pnummer).getSingleResult();
        return w.getBNummer();
    }
    
    public int getWerkType(int pnummer)
    {
        Werknemers w = em.find(Werknemers.class, pnummer);
        return w.getWerkType();
    }
    
    
    
/*  *** Onkosten ***  */
    public List getOnkosten(int pnummer)
    {
        return em.createNamedQuery("Onkosten.findByPnummer").setParameter("pnummer", pnummer).getResultList();
    }
    
    public int getOnkostId(int pnummer)
    {
        return (int) em.createNamedQuery("Onkosten.laatsteOnkId").setParameter("pnummer", pnummer).getSingleResult();
    }
    
    public Onkosten getOnkostById(int onkostId)
    {
        return (Onkosten) em.createNamedQuery("Onkosten.findByOnkostId").setParameter("onkostId", onkostId).getSingleResult();
    }
    
    public void setOnkostStatus(int onkostId, String status)
    {
        Onkosten k = (Onkosten) em.createNamedQuery("Onkosten.findByOnkostId").setParameter("onkostId", onkostId).getSingleResult();
        k.setStatus(status);
    }
    
    public void setOnkost(int onkostId, String omschrijving, Date datum, double onkBedrag, String status)
    {
        Onkosten o = (Onkosten) em.createNamedQuery("Onkosten.findByOnkostId").setParameter("onkostId", onkostId).getSingleResult();
        o.setDatum(datum);
        o.setOmschrijving(omschrijving);
        o.setOnkostenBedrag(onkBedrag);
        o.setStatus(status);
        em.persist(o);
    }
    
    public void deleteOnkost(int onkostId)
    {
        Onkosten k = (Onkosten) em.createNamedQuery("Onkosten.findByOnkostId").setParameter("onkostId", onkostId).getSingleResult();
        em.remove(k);
    }
    
    
    
/*  *** Kredieten ***  */
    public List getKredietenAll(int pnummer)
    {
        return em.createNamedQuery("Kredieten.findByPnummer").setParameter("pnummer", pnummer).getResultList();
    }
    
    public List getKredietenEigenEnBaas(int pnummer, int bnummer)
    {
        List eigenKred = em.createNamedQuery("Kredieten.eigenKredieten").setParameter("pnummer", pnummer).getResultList();
        //Alleen als de ingelogde persoon niet zelf zijn eigen baas is, worden de kredieten van zijn baas ook toegevoegd aan de lijst.
        if(pnummer != bnummer)
        {
            List baasKred = em.createNamedQuery("Kredieten.baasKredieten").setParameter("bnummer", bnummer).getResultList();
            eigenKred.addAll(baasKred);
        }
        return eigenKred;
    }
    
    public void setNegatief(int krNummer, int getal)
    {
        Kredieten k = (Kredieten) em.createNamedQuery("Kredieten.findByKrNummer").setParameter("krNummer", krNummer).getSingleResult();
        k.setNegatief(getal);
        em.persist(k);
    }
    
    public Kredieten getKredietById(int krNummer)
    {
       return (Kredieten) em.createNamedQuery("Kredieten.findByKrNummer").setParameter("krNummer", krNummer).getSingleResult();
    }
    
    public void setKredietSaldo(int krNummer, double saldo)
    {
        Kredieten k = (Kredieten) em.createNamedQuery("Kredieten.findByKrNummer").setParameter("krNummer", krNummer).getSingleResult();
        k.setKrSaldo(saldo);
    }
}
