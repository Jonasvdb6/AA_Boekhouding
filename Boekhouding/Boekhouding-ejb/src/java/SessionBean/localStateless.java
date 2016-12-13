/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.io.Console;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonas
 */
@Stateless
public class localStateless implements localStatelessLocal 
{
    
    @PersistenceContext
    private EntityManager em;
    
    public int getBNumer(int pnummer)
    {
        Werknemers w = em.find (Werknemers.class, pnummer);
        //Werknemers w = (Werknemers) em.createNamedQuery("Werknemers.findByPNummer").setParameter("pNummer", pnummer).getSingleResult();
        return w.getBNummer();
    }
}
