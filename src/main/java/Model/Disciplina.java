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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Henrique
 */
@Entity
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d")
    , @NamedQuery(name = "Disciplina.findByIdDisciplina", query = "SELECT d FROM Disciplina d WHERE d.idDisciplina = :idDisciplina")
    , @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome")
    , @NamedQuery(name = "Disciplina.findByCargaHoraria", query = "SELECT d FROM Disciplina d WHERE d.cargaHoraria = :cargaHoraria")
    , @NamedQuery(name = "Disciplina.findByHorario", query = "SELECT d FROM Disciplina d WHERE d.horario = :horario")
    , @NamedQuery(name = "Disciplina.findByPeriodo", query = "SELECT d FROM Disciplina d WHERE d.periodo = :periodo")
    , @NamedQuery(name = "Disciplina.findByRequisito", query = "SELECT d FROM Disciplina d WHERE d.periodo = :requisito")})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDisciplina")
    private Integer idDisciplina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CargaHoraria")
    private String cargaHoraria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Horario")
    private String horario;
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Dia")
    private String dias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Periodo")
    private int periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Requisito")
    private String requisito;
    @JoinColumn(name = "Professor_Siape", referencedColumnName = "Siape")
    @ManyToOne(optional = false)
    private Professor professorSiape;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<DisciplinaHasAluno> disciplinaHasAlunoList;

    public Disciplina() {
    }

    public Disciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Disciplina(Integer idDisciplina, String nome, String cargaHoraria, String horario, int periodo, String dias) {
        this.idDisciplina = idDisciplina;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.horario = horario;
        this.periodo = periodo;
        this.dias = dias;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Professor getProfessorSiape() {
        return professorSiape;
    }

    public void setProfessorSiape(Professor professorSiape) {
        this.professorSiape = professorSiape;
    }
    
    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }
    

    @XmlTransient
    public List<DisciplinaHasAluno> getDisciplinaHasAlunoList() {
        return disciplinaHasAlunoList;
    }

    public void setDisciplinaHasAlunoList(List<DisciplinaHasAluno> disciplinaHasAlunoList) {
        this.disciplinaHasAlunoList = disciplinaHasAlunoList;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
    

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisciplina != null ? idDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.idDisciplina == null && other.idDisciplina != null) || (this.idDisciplina != null && !this.idDisciplina.equals(other.idDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Disciplina[ idDisciplina=" + idDisciplina + " ]";
    }
    
}
