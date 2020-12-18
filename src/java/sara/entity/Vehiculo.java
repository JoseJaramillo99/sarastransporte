/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author mompo
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VehiculoPK vehiculoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehmodelo")
    private int vehmodelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vehmarca")
    private String vehmarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vehestado")
    private String vehestado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehprecio")
    private int vehprecio;
    @JoinColumn(name = "categoria_caid", referencedColumnName = "caid", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoria;
    @JoinColumn(name = "datospersonales_datid", referencedColumnName = "datid", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Datospersonales datospersonales;

    public Vehiculo() {
    }

    public Vehiculo(VehiculoPK vehiculoPK) {
        this.vehiculoPK = vehiculoPK;
    }

    public Vehiculo(VehiculoPK vehiculoPK, int vehmodelo, String vehmarca, String vehestado, int vehprecio) {
        this.vehiculoPK = vehiculoPK;
        this.vehmodelo = vehmodelo;
        this.vehmarca = vehmarca;
        this.vehestado = vehestado;
        this.vehprecio = vehprecio;
    }

    public Vehiculo(String vehplaca, int datospersonalesDatid, int categoriaCaid) {
        this.vehiculoPK = new VehiculoPK(vehplaca, datospersonalesDatid, categoriaCaid);
    }

    public VehiculoPK getVehiculoPK() {
        return vehiculoPK;
    }

    public void setVehiculoPK(VehiculoPK vehiculoPK) {
        this.vehiculoPK = vehiculoPK;
    }

    public int getVehmodelo() {
        return vehmodelo;
    }

    public void setVehmodelo(int vehmodelo) {
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

    public int getVehprecio() {
        return vehprecio;
    }

    public void setVehprecio(int vehprecio) {
        this.vehprecio = vehprecio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Datospersonales getDatospersonales() {
        return datospersonales;
    }

    public void setDatospersonales(Datospersonales datospersonales) {
        this.datospersonales = datospersonales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehiculoPK != null ? vehiculoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.vehiculoPK == null && other.vehiculoPK != null) || (this.vehiculoPK != null && !this.vehiculoPK.equals(other.vehiculoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sara.entity.Vehiculo[ vehiculoPK=" + vehiculoPK + " ]";
    }
    
}
