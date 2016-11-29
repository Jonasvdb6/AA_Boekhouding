/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;

/**
 *
 * @author jonas
 */
public class Onkost 
{
    
    private int onkostId;
    private String omschrijving;
    private Date datum;
    private double onkostBedrag;
    private String status; //in aanmaak, doorgestuurd, betaald, afgekeurd

    
    public int getOnkostId() {
        return onkostId;
    }

    public void setOnkostId(int onkId) {
        onkostId = onkId;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschr) {
        omschrijving = omschr;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date date) {
        datum = date;
    }

    public double getOnkostBedrag() {
        return onkostBedrag;
    }

    public void setOnkostBedrag(double onkBedr) {
        onkostBedrag = onkBedr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String stat) {
        status = stat;
    }
}
