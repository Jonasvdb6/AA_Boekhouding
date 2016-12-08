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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonas
 */
@Entity
@Table(name = "kredieten")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kredieten.findAll", query = "SELECT k FROM Kredieten k"),
    @NamedQuery(name = "Kredieten.findByKrNummer", query = "SELECT k FROM Kredieten k WHERE k.krNummer = :krNummer"),
    @NamedQuery(name = "Kredieten.findByKrSaldo", query = "SELECT k FROM Kredieten k WHERE k.krSaldo = :krSaldo"),
    @NamedQuery(name = "Kredieten.findByKrType", query = "SELECT k FROM Kredieten k WHERE k.krType = :krType"),
    @NamedQuery(name = "Kredieten.findByPnummer", query = "SELECT k FROM Kredieten k WHERE k.pnummer = :pnummer")})
public class Kredieten implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "krNummer")
    private Integer krNummer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "krSaldo")
    private double krSaldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "krType")
    private int krType;
    @Column(name = "pnummer")
    private Integer pnummer;

    public Kredieten() {
    }

    public Kredieten(Integer krNummer) {
        this.krNummer = krNummer;
    }

    public Kredieten(Integer krNummer, double krSaldo, int krType) {
        this.krNummer = krNummer;
        this.krSaldo = krSaldo;
        this.krType = krType;
    }

    public Integer getKrNummer() {
        return krNummer;
    }

    public void setKrNummer(Integer krNummer) {
        this.krNummer = krNummer;
    }

    public double getKrSaldo() {
        return krSaldo;
    }

    public void setKrSaldo(double krSaldo) {
        this.krSaldo = krSaldo;
    }

    public int getKrType() {
        return krType;
    }

    public void setKrType(int krType) {
        this.krType = krType;
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
        hash += (krNummer != null ? krNummer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kredieten)) {
            return false;
        }
        Kredieten other = (Kredieten) object;
        if ((this.krNummer == null && other.krNummer != null) || (this.krNummer != null && !this.krNummer.equals(other.krNummer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SessionBean.Kredieten[ krNummer=" + krNummer + " ]";
    }
    
}
