/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonas
 */
@Stateless
public class GuiBean implements GuiBeanRemote 
{
    
    @PersistenceContext
    private EntityManager em;
    
    public String getKrediet(int krNummer)
    {
        Kredieten k = (Kredieten) em.createNamedQuery("Kredieten.findByKrNummer").setParameter("krNummer", krNummer).getSingleResult();
        String s = k.toString();
        s += "Hieronder volg een opsomming van de onkosten die op dit krediet geboekt zijn.\n";
        List onkosten = em.createNamedQuery("Onkosten.onkostenVanKrediet").setParameter("krNummer", krNummer).getResultList();
        if(onkosten.size() != 0)
        {
            for(int i=0; i<onkosten.size(); i++)
            {
                s += onkosten.get(i).toString();
            }
        }
        else
        {
            s += "Er zijn geen onkosten geboekt op dit krediet.\n";
        }
        return s;
    }
    
    public int getMaxKredietId()
    {
        return (int) em.createNamedQuery("Kredieten.getMaxKredietId").getSingleResult();
    }
}
