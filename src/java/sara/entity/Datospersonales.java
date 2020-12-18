/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mompo
 */
@Entity
@Table(name = "datospersonales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datospersonales.findAll", query = "SELECT d FROM Datospersonales d")})
public class Datospersonales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "datid")
    private Integer datid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "datnombre")
    private String datnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "datapellido")
    private String datapellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "datipoid")
    private String datipoid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "datnumeroid")
    private String datnumeroid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "datelefono")
    private String datelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "datcorreo")
    private String datcorreo;
    @JoinColumn(name = "usuario_usuid", referencedColumnName = "usuid")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioUsuid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datospersonales", fetch = FetchType.LAZY)
    private Collection<Vehiculo> vehiculoCollection;

    public Datospersonales() {
    }

    public Datospersonales(Integer datid) {
        this.datid = datid;
    }

    public Datospersonales(Integer datid, String datnombre, String datapellido, String datipoid, String datnumeroid, String datelefono, String datcorreo) {
        this.datid = datid;
        this.datnombre = datnombre;
        this.datapellido = datapellido;
        this.datipoid = datipoid;
        this.datnumeroid = datnumeroid;
        this.datelefono = datelefono;
        this.datcorreo = datcorreo;
    }

    public Integer getDatid() {
        return datid;
    }

    public void setDatid(Integer datid) {
        this.datid = datid;
    }

    public String getDatnombre() {
        return datnombre;
    }

    public void setDatnombre(String datnombre) {
        this.datnombre = datnombre;
    }

    public String getDatapellido() {
        return datapellido;
    }

    public void setDatapellido(String datapellido) {
        this.datapellido = datapellido;
    }

    public String getDatipoid() {
        return datipoid;
    }

    public void setDatipoid(String datipoid) {
        this.datipoid = datipoid;
    }

    public String getDatnumeroid() {
        return datnumeroid;
    }

    public void setDatnumeroid(String datnumeroid) {
        this.datnumeroid = datnumeroid;
    }

    public String getDatelefono() {
        return datelefono;
    }

    public void setDatelefono(String datelefono) {
        this.datelefono = datelefono;
    }

    public String getDatcorreo() {
        return datcorreo;
    }

    public void setDatcorreo(String datcorreo) {
        this.datcorreo = datcorreo;
    }

    public Usuario getUsuarioUsuid() {
        return usuarioUsuid;
    }

    public void setUsuarioUsuid(Usuario usuarioUsuid) {
        this.usuarioUsuid = usuarioUsuid;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datid != null ? datid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datospersonales)) {
            return false;
        }
        Datospersonales other = (Datospersonales) object;
        if ((this.datid == null && other.datid != null) || (this.datid != null && !this.datid.equals(other.datid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sara.entity.Datospersonales[ datid=" + datid + " ]";
    }
    
}
