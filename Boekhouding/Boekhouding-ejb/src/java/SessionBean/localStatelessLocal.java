/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jonas
 */
@Local
public interface localStatelessLocal 
{
    public int getBNumer(int pnummer);
    public int getWerkType(int pnummer);
    public List getOnkosten(int pnummer);
    public int getNewOnkostId(int pnummer);
}
