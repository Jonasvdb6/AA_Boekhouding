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

    public void setOnkostId(int onkostId) {
        this.onkostId = onkostId;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String s) {
        omschrijving = s;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date d) {
        datum = d;
    }

    public double getOnkostBedrag() {
        return onkostBedrag;
    }

    public void setOnkostBedrag(double x) {
        onkostBedrag = x;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String s) {
        status = s;
    }
}