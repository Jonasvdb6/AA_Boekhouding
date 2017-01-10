/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import javax.ejb.Remote;

/**
 *
 * @author jonas
 */
@Remote
public interface GuiBeanRemote 
{
    public String getKrediet(int krNummer);
    public int getMaxKredietId();
}
