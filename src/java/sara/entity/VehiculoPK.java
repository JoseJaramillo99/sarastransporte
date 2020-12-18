/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mompo
 */
@Embeddable
public class VehiculoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "vehplaca")
    private String vehplaca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datospersonales_datid")
    private int datospersonalesDatid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria_caid")
    private int categoriaCaid;

    public VehiculoPK() {
    }

    public VehiculoPK(String vehplaca, int datospersonalesDatid, int categoriaCaid) {
        this.vehplaca = vehplaca;
        this.datospersonalesDatid = datospersonalesDatid;
        this.categoriaCaid = categoriaCaid;
    }

    public String getVehplaca() {
        return vehplaca;
    }

    public void setVehplaca(String vehplaca) {
        this.vehplaca = vehplaca;
    }

    public int getDatospersonalesDatid() {
        return datospersonalesDatid;
    }

    public void setDatospersonalesDatid(int datospersonalesDatid) {
        this.datospersonalesDatid = datospersonalesDatid;
    }

    public int getCategoriaCaid() {
        return categoriaCaid;
    }

    public void setCategoriaCaid(int categoriaCaid) {
        this.categoriaCaid = categoriaCaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehplaca != null ? vehplaca.hashCode() : 0);
        hash += (int) datospersonalesDatid;
        hash += (int) categoriaCaid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoPK)) {
            return false;
        }
        VehiculoPK other = (VehiculoPK) object;
        if ((this.vehplaca == null && other.vehplaca != null) || (this.vehplaca != null && !this.vehplaca.equals(other.vehplaca))) {
            return false;
        }
        if (this.datospersonalesDatid != other.datospersonalesDatid) {
            return false;
        }
        if (this.categoriaCaid != other.categoriaCaid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sara.entity.VehiculoPK[ vehplaca=" + vehplaca + ", datospersonalesDatid=" + datospersonalesDatid + ", categoriaCaid=" + categoriaCaid + " ]";
    }
    
}
