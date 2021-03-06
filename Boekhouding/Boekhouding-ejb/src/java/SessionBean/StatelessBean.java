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
    
    public int getOnkostId()
    {
        return (int) em.createNamedQuery("Onkosten.laatsteOnkId").getSingleResult();
    }
    
    public Onkosten getOnkostById(int onkostId)
    {
        return (Onkosten) em.createNamedQuery("Onkosten.findByOnkostId").setParameter("onkostId", onkostId).getSingleResult();
    }
    
    public void setOnkostStatus(int onkostId, String status)
    {
        Onkosten k = (Onkosten) em.createNamedQuery("Onkosten.findByOnkostId").setParameter("onkostId", onkostId).getSingleResult();
        k.setStatus(status);
        em.persist(k);
    }
    
    public void setOnkostKrediet(int onkostId, int krNummer)
    {
        Onkosten k = (Onkosten) em.createNamedQuery("Onkosten.findByOnkostId").setParameter("onkostId", onkostId).getSingleResult();
        k.setKrNummer(krNummer);
        em.persist(k);
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
    
    public void maakNewOnkost(int onkId, String omsch, Date d, double onkBed, String stat, int pnr, int krNr)
    {
        Onkosten nieuw = new Onkosten(onkId, omsch, d, onkBed, stat, pnr, krNr);
        em.persist(nieuw);
    }
    
    public List getOnkostenKrediet(int krNummer)
    {
        return em.createNamedQuery("Onkosten.onkostenVanKrediet").setParameter("krNummer", krNummer).getResultList();
    }
    
    public int getKrNummerVanOnkost(int onkostId)
    {
        Onkosten o = (Onkosten) em.createNamedQuery("Onkosten.findByOnkostId").setParameter("onkostId", onkostId).getSingleResult();
        return o.getKrNummer();
    }
    
    public List getOnkostenManager(int pnummer)
    {
        List kredieten = em.createNamedQuery("Kredieten.findByPnummer").setParameter("pnummer", pnummer).getResultList();
        List onkosten = new ArrayList();
        for(int i=0; i<kredieten.size(); i++)
        {
            Kredieten k = (Kredieten) kredieten.get(i);
            int krNummer = k.getKrNummer();
            List onkostenPerKrediet = em.createNamedQuery("Onkosten.onkostenVanKredietDoorgestuurd").setParameter("krNummer", krNummer).getResultList();
            onkosten.addAll(onkostenPerKrediet);
        }
        return onkosten;
    }
    
    
    
/*  *** Kredieten ***  */
    public List getKredietenAll()
    {
        return em.createNamedQuery("Kredieten.findAll").getResultList();
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