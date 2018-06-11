/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henrique
 */
@Entity
@Table(name = "telefoneadministrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefoneadministrador.findAll", query = "SELECT t FROM Telefoneadministrador t")
    , @NamedQuery(name = "Telefoneadministrador.findByIdTelefone", query = "SELECT t FROM Telefoneadministrador t WHERE t.idTelefone = :idTelefone")
    , @NamedQuery(name = "Telefoneadministrador.findByTelefone", query = "SELECT t FROM Telefoneadministrador t WHERE t.telefone = :telefone")})
public class Telefoneadministrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTelefone")
    private Integer idTelefone;
    @Column(name = "Telefone")
    private String telefone;
    @JoinColumn(name = "Administrador_idAdministrador", referencedColumnName = "idAdministrador")
    @ManyToOne(optional = false)
    private Administrador administradoridAdministrador;

    public Telefoneadministrador() {
    }

    public Telefoneadministrador(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Administrador getAdministradoridAdministrador() {
        return administradoridAdministrador;
    }

    public void setAdministradoridAdministrador(Administrador administradoridAdministrador) {
        this.administradoridAdministrador = administradoridAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefone != null ? idTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefoneadministrador)) {
            return false;
        }
        Telefoneadministrador other = (Telefoneadministrador) object;
        if ((this.idTelefone == null && other.idTelefone != null) || (this.idTelefone != null && !this.idTelefone.equals(other.idTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Telefoneadministrador[ idTelefone=" + idTelefone + " ]";
    }

}
