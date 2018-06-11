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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henrique
 */
@Entity
@Table(name = "telefoneprofessor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefoneprofessor.findAll", query = "SELECT t FROM Telefoneprofessor t")
    , @NamedQuery(name = "Telefoneprofessor.findByIdTelefone", query = "SELECT t FROM Telefoneprofessor t WHERE t.idTelefone = :idTelefone")
    , @NamedQuery(name = "Telefoneprofessor.findByTelefone", query = "SELECT t FROM Telefoneprofessor t WHERE t.telefone = :telefone")})
public class Telefoneprofessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTelefone")
    private Integer idTelefone;
    @Column(name = "Telefone")
    private String telefone;
    @JoinColumn(name = "Professor_Siape", referencedColumnName = "Siape")
    @ManyToOne(optional = false)
    private Professor professorSiape;

    public Telefoneprofessor() {
    }

    public Telefoneprofessor(Integer idTelefone) {
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

    public Professor getProfessorSiape() {
        return professorSiape;
    }

    public void setProfessorSiape(Professor professorSiape) {
        this.professorSiape = professorSiape;
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
        if (!(object instanceof Telefoneprofessor)) {
            return false;
        }
        Telefoneprofessor other = (Telefoneprofessor) object;
        if ((this.idTelefone == null && other.idTelefone != null) || (this.idTelefone != null && !this.idTelefone.equals(other.idTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Telefoneprofessor[ idTelefone=" + idTelefone + " ]";
    }

}
