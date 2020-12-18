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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * @author victo
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuid")
    private Integer usuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usulogin")
    private String usulogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usupass")
    private String usupass;
    @ManyToMany(mappedBy = "usuarioCollection", fetch = FetchType.LAZY)
    private Collection<Rol> rolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuid", fetch = FetchType.LAZY)
    private Collection<Datospersonales> datospersonalesCollection;

    public Usuario() {
    }

    public Usuario(Integer usuid) {
        this.usuid = usuid;
    }

    public Usuario(Integer usuid, String usulogin, String usupass) {
        this.usuid = usuid;
        this.usulogin = usulogin;
        this.usupass = usupass;
    }

    public Integer getUsuid() {
        return usuid;
    }

    public void setUsuid(Integer usuid) {
        this.usuid = usuid;
    }

    public String getUsulogin() {
        return usulogin;
    }

    public void setUsulogin(String usulogin) {
        this.usulogin = usulogin;
    }

    public String getUsupass() {
        return usupass;
    }

    public void setUsupass(String usupass) {
        this.usupass = usupass;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @XmlTransient
    public Collection<Datospersonales> getDatospersonalesCollection() {
        return datospersonalesCollection;
    }

    public void setDatospersonalesCollection(Collection<Datospersonales> datospersonalesCollection) {
        this.datospersonalesCollection = datospersonalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuid != null ? usuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuid == null && other.usuid != null) || (this.usuid != null && !this.usuid.equals(other.usuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sara.entity.Usuario[ usuid=" + usuid + " ]";
    }
    
}
