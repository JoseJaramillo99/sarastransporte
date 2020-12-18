/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "vehplaca")
    private String vehplaca;
    @Column(name = "vehmodelo")
    private Integer vehmodelo;
    @Size(max = 50)
    @Column(name = "vehmarca")
    private String vehmarca;
    @Size(max = 30)
    @Column(name = "vehestado")
    private String vehestado;
    @Column(name = "vehprecio")
    private Integer vehprecio;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @JoinColumn(name = "caid", referencedColumnName = "caid")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria caid;
    @JoinColumn(name = "datid", referencedColumnName = "datid")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Datospersonales datid;

    public Vehiculo() {
    }

    public Vehiculo(String vehplaca) {
        this.vehplaca = vehplaca;
    }

    public String getVehplaca() {
        return vehplaca;
    }

    public void setVehplaca(String vehplaca) {
        this.vehplaca = vehplaca;
    }

    public Integer getVehmodelo() {
        return vehmodelo;
    }

    public void setVehmodelo(Integer vehmodelo) {
        this.vehmodelo = vehmodelo;
    }

    public String getVehmarca() {
        return vehmarca;
    }

    public void setVehmarca(String vehmarca) {
        this.vehmarca = vehmarca;
    }

    public String getVehestado() {
        return vehestado;
    }

    public void setVehestado(String vehestado) {
        this.vehestado = vehestado;
    }

    public Integer getVehprecio() {
        return vehprecio;
    }

    public void setVehprecio(Integer vehprecio) {
        this.vehprecio = vehprecio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Categoria getCaid() {
        return caid;
    }

    public void setCaid(Categoria caid) {
        this.caid = caid;
    }

    public Datospersonales getDatid() {
        return datid;
    }

    public void setDatid(Datospersonales datid) {
        this.datid = datid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehplaca != null ? vehplaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.vehplaca == null && other.vehplaca != null) || (this.vehplaca != null && !this.vehplaca.equals(other.vehplaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sara.entity.Vehiculo[ vehplaca=" + vehplaca + " ]";
    }
    
}
