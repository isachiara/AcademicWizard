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
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findByMatricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula")
    , @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome")
    , @NamedQuery(name = "Aluno.findByCpf", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf")
    , @NamedQuery(name = "Aluno.findBySexo", query = "SELECT a FROM Aluno a WHERE a.sexo = :sexo")
    , @NamedQuery(name = "Aluno.findBySenha", query = "SELECT a FROM Aluno a WHERE a.senha = :senha")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CPF")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Senha")
    private String senha;
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Curso")
    private String curso;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_enderecoaluno", referencedColumnName = "idEndereco")
    private Enderecoaluno enderecoaluno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoMatricula")
    private List<Telefonealuno> telefonealunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<DisciplinaHasAluno> disciplinaHasAlunoList;


    public Aluno() {
    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public Aluno(String matricula, String nome, String cpf, String sexo, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.senha = senha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Enderecoaluno getEnderecoaluno() {
        return enderecoaluno;
    }

    public void setEnderecoaluno(Enderecoaluno enderecoaluno) {
        this.enderecoaluno = enderecoaluno;
    }

    
    @XmlTransient
    public List<Telefonealuno> getTelefonealunoList() {
        return telefonealunoList;
    }

    public void setTelefonealunoList(List<Telefonealuno> telefonealunoList) {
        this.telefonealunoList = telefonealunoList;
    }

    @XmlTransient
    public List<DisciplinaHasAluno> getDisciplinaHasAlunoList() {
        return disciplinaHasAlunoList;
    }

    public void setDisciplinaHasAlunoList(List<DisciplinaHasAluno> disciplinaHasAlunoList) {
        this.disciplinaHasAlunoList = disciplinaHasAlunoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Aluno[ matricula=" + matricula + " ]";
    }
    
}
