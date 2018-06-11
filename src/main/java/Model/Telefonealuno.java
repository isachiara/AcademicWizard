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
@Table(name = "telefonealuno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonealuno.findAll", query = "SELECT t FROM Telefonealuno t")
    , @NamedQuery(name = "Telefonealuno.findByIdTelefone", query = "SELECT t FROM Telefonealuno t WHERE t.idTelefone = :idTelefone")
    , @NamedQuery(name = "Telefonealuno.findByTelefonecol", query = "SELECT t FROM Telefonealuno t WHERE t.telefonecol = :telefonecol")})
public class Telefonealuno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTelefone")
    private Integer idTelefone;
    @Column(name = "Telefonecol")
    private String telefonecol;
    @JoinColumn(name = "Aluno_Matricula", referencedColumnName = "Matricula")
    @ManyToOne(optional = false)
    private Aluno alunoMatricula;

    public Telefonealuno() {
    }

    public Telefonealuno(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefonecol() {
        return telefonecol;
    }

    public void setTelefonecol(String telefonecol) {
        this.telefonecol = telefonecol;
    }

    public Aluno getAlunoMatricula() {
        return alunoMatricula;
    }

    public void setAlunoMatricula(Aluno alunoMatricula) {
        this.alunoMatricula = alunoMatricula;
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
        if (!(object instanceof Telefonealuno)) {
            return false;
        }
        Telefonealuno other = (Telefonealuno) object;
        if ((this.idTelefone == null && other.idTelefone != null) || (this.idTelefone != null && !this.idTelefone.equals(other.idTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Telefonealuno[ idTelefone=" + idTelefone + " ]";
    }

}
