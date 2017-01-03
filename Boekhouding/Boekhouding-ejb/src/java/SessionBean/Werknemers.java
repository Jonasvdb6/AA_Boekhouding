/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author jonas
 */
@Entity
@Table(name = "werknemers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Werknemers.findAll", query = "SELECT w FROM Werknemers w"),
    @NamedQuery(name = "Werknemers.findByPNummer", query = "SELECT w FROM Werknemers w WHERE w.pNummer = :pNummer"),
    @NamedQuery(name = "Werknemers.findByPswd", query = "SELECT w FROM Werknemers w WHERE w.pswd = :pswd"),
    @NamedQuery(name = "Werknemers.findByWerkType", query = "SELECT w FROM Werknemers w WHERE w.werkType = :werkType"),
    @NamedQuery(name = "Werknemers.findByBNummer", query = "SELECT w FROM Werknemers w WHERE w.bNummer = :bNummer")})
public class Werknemers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pNummer")
    private Integer pNummer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "pswd")
    private String pswd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "werkType")
    private int werkType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bNummer")
    private int bNummer;

    public Werknemers() {
    }

    public Werknemers(Integer pNummer) {
        this.pNummer = pNummer;
    }

    public Werknemers(Integer pNummer, String pswd, int werkType, int bNummer) {
        this.pNummer = pNummer;
        this.pswd = pswd;
        this.werkType = werkType;
        this.bNummer = bNummer;
    }

    public Integer getPNummer() {
        return pNummer;
    }

    public void setPNummer(Integer pNummer) {
        this.pNummer = pNummer;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public int getWerkType() {
        return werkType;
    }

    public void setWerkType(int werkType) {
        this.werkType = werkType;
    }

    public int getBNummer() {
        return bNummer;
    }

    public void setBNummer(int bNummer) {
        this.bNummer = bNummer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pNummer != null ? pNummer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Werknemers)) {
            return false;
        }
        Werknemers other = (Werknemers) object;
        if ((this.pNummer == null && other.pNummer != null) || (this.pNummer != null && !this.pNummer.equals(other.pNummer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SessionBean.Werknemers[ pNummer=" + pNummer + " ]";
    }
    
}
