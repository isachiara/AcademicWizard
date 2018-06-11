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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henrique
 */
@Entity
@Table(name = "enderecoprofessor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enderecoprofessor.findAll", query = "SELECT e FROM Enderecoprofessor e")
    , @NamedQuery(name = "Enderecoprofessor.findByIdEndereco", query = "SELECT e FROM Enderecoprofessor e WHERE e.idEndereco = :idEndereco")
    , @NamedQuery(name = "Enderecoprofessor.findByEstado", query = "SELECT e FROM Enderecoprofessor e WHERE e.estado = :estado")
    , @NamedQuery(name = "Enderecoprofessor.findByCidade", query = "SELECT e FROM Enderecoprofessor e WHERE e.cidade = :cidade")
    , @NamedQuery(name = "Enderecoprofessor.findByBairro", query = "SELECT e FROM Enderecoprofessor e WHERE e.bairro = :bairro")
    , @NamedQuery(name = "Enderecoprofessor.findByRua", query = "SELECT e FROM Enderecoprofessor e WHERE e.rua = :rua")
    , @NamedQuery(name = "Enderecoprofessor.findByNumero", query = "SELECT e FROM Enderecoprofessor e WHERE e.numero = :numero")
    , @NamedQuery(name = "Enderecoprofessor.findByCep", query = "SELECT e FROM Enderecoprofessor e WHERE e.cep = :cep")})
public class Enderecoprofessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEndereco")
    private Integer idEndereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Rua")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cep")
    private String cep;
    @JoinColumn(name = "Professor_Siape", referencedColumnName = "Siape")
    @ManyToOne(optional = false)
    private Professor professorSiape;

    public Enderecoprofessor() {
    }

    public Enderecoprofessor(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Enderecoprofessor(Integer idEndereco, String estado, String cidade, String bairro, String rua, String numero, String cep) {
        this.idEndereco = idEndereco;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enderecoprofessor)) {
            return false;
        }
        Enderecoprofessor other = (Enderecoprofessor) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Enderecoprofessor[ idEndereco=" + idEndereco + " ]";
    }

}
