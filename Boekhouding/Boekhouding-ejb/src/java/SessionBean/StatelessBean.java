/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
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
    
    public List getOnkosten(int pnummer)
    {
        return em.createNamedQuery("Onkosten.findByPnummer").setParameter("pnummer", pnummer).getResultList();
    }
    
    public int getNewOnkostId(int pnummer)
    {
        //De query geeft de laatste onkostId terug dus +1 om een nieuwe onkostId toe te voegen
        return (int) em.createNamedQuery("Onkosten.laatsteOnkId").setParameter("pnummer", pnummer).getSingleResult();
    }
    
    public List getKredietenAll(int pnummer)
    {
        return em.createNamedQuery("Kredieten.findByPnummer").setParameter("pnummer", pnummer).getResultList();
    }
    
    public Onkosten getOnkostById(int onkostId)
    {
        return (Onkosten) em.createNamedQuery("Onkosten.findByOnkostId").setParameter("onkostId", onkostId).getSingleResult();
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
}
