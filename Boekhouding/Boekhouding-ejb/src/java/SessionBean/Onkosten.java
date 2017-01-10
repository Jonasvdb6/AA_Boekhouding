/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonas
 */
@Entity
@Table(name = "onkosten")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onkosten.findAll", query = "SELECT o FROM Onkosten o"),
    @NamedQuery(name = "Onkosten.findByOnkostId", query = "SELECT o FROM Onkosten o WHERE o.onkostId = :onkostId"),
    @NamedQuery(name = "Onkosten.findByOmschrijving", query = "SELECT o FROM Onkosten o WHERE o.omschrijving = :omschrijving"),
    @NamedQuery(name = "Onkosten.findByDatum", query = "SELECT o FROM Onkosten o WHERE o.datum = :datum"),
    @NamedQuery(name = "Onkosten.findByOnkostenBedrag", query = "SELECT o FROM Onkosten o WHERE o.onkostenBedrag = :onkostenBedrag"),
    @NamedQuery(name = "Onkosten.findByStatus", query = "SELECT o FROM Onkosten o WHERE o.status = :status"),
    @NamedQuery(name = "Onkosten.findByPnummer", query = "SELECT o FROM Onkosten o WHERE o.pnummer = :pnummer"),
    //Query om laaste onkostId op te vragen:
    @NamedQuery(name = "Onkosten.laatsteOnkId", query = "SELECT MAX(o.onkostId) FROM Onkosten o")})
public class Onkosten implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "onkostId")
    private Integer onkostId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "omschrijving")
    private String omschrijving;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onkostenBedrag")
    private double onkostenBedrag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "status")
    private String status;
    @Column(name = "pnummer")
    private Integer pnummer;

    public Onkosten() {
    }

    public Onkosten(Integer onkostId) {
        this.onkostId = onkostId;
    }

    public Onkosten(Integer onkostId, String omschrijving, Date datum, double onkostenBedrag, String status) {
        this.onkostId = onkostId;
        this.omschrijving = omschrijving;
        this.datum = datum;
        this.onkostenBedrag = onkostenBedrag;
        this.status = status;
    }

    public Integer getOnkostId() {
        return onkostId;
    }

    public void setOnkostId(Integer onkostId) {
        this.onkostId = onkostId;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getOnkostenBedrag() {
        return onkostenBedrag;
    }

    public void setOnkostenBedrag(double onkostenBedrag) {
        this.onkostenBedrag = onkostenBedrag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPnummer() {
        return pnummer;
    }

    public void setPnummer(Integer pnummer) {
        this.pnummer = pnummer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (onkostId != null ? onkostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onkosten)) {
            return false;
        }
        Onkosten other = (Onkosten) object;
        if ((this.onkostId == null && other.onkostId != null) || (this.onkostId != null && !this.onkostId.equals(other.onkostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SessionBean.Onkosten[ onkostId=" + onkostId + " ]";
    }
    
}
