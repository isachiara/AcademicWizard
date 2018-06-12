/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Henrique
 */
@Entity
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
    , @NamedQuery(name = "Professor.findBySiape", query = "SELECT p FROM Professor p WHERE p.siape = :siape")
    , @NamedQuery(name = "Professor.findByNome", query = "SELECT p FROM Professor p WHERE p.nome = :nome")
    , @NamedQuery(name = "Professor.findBySexo", query = "SELECT p FROM Professor p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "Professor.findByCpf", query = "SELECT p FROM Professor p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "Professor.findBySenha", query = "SELECT p FROM Professor p WHERE p.senha = :senha")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Siape")
    private String siape;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CPF")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Senha")
    private String senha;
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Curso")
    private String curso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professorSiape")
    private List<Disciplina> disciplinaList;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_enderecoprofessor", referencedColumnName = "idEndereco")
    private Enderecoprofessor enderecoprofessor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professorSiape")
    private List<Telefoneprofessor> telefoneprofessorList;

    public Professor() {
    }

    public Professor(String siape) {
        this.siape = siape;
    }

    public Professor(String siape, String nome, String sexo, String cpf, String senha) {
        this.siape = siape;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<Disciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
    }

    @XmlTransient
    public Enderecoprofessor getEnderecoprofessor() {
        return enderecoprofessor;
    }

    public void setEnderecoprofessor(Enderecoprofessor enderecoprofessor) {
        this.enderecoprofessor = enderecoprofessor;
    }

    @XmlTransient
    public List<Telefoneprofessor> getTelefoneprofessorList() {
        return telefoneprofessorList;
    }

    public void setTelefoneprofessorList(List<Telefoneprofessor> telefoneprofessorList) {
        this.telefoneprofessorList = telefoneprofessorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siape != null ? siape.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.siape == null && other.siape != null) || (this.siape != null && !this.siape.equals(other.siape))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Professor[ siape=" + siape + " ]";
    }
    
}