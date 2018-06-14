/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "disciplina_has_aluno")
@XmlRootElement
public class DisciplinaHasAluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDisciplinaHasAluno")
    private Integer IDDisciplinaHasAluno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EstadoDisciplina")
    private String estadoDisciplina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nota")
    private float nota;
    @JoinColumn(name = "Aluno_Matricula", referencedColumnName = "Matricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;
    @JoinColumn(name = "Disciplina_idDisciplina", referencedColumnName = "idDisciplina", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public DisciplinaHasAluno() {
    }

    public DisciplinaHasAluno(int IDDisciplinaHasAluno) {
        this.IDDisciplinaHasAluno = IDDisciplinaHasAluno;
    }

    public DisciplinaHasAluno(int IDDisciplinaHasAluno, String estadoDisciplina, float nota) {
        this.IDDisciplinaHasAluno = IDDisciplinaHasAluno;
        this.estadoDisciplina = estadoDisciplina;
        this.nota = nota;
    }

    public int getDisciplinaHasAlunoID() {
        return IDDisciplinaHasAluno;
    }

    public void setDisciplinaHasAlunoID(int IDDisciplinaHasAluno) {
        this.IDDisciplinaHasAluno = IDDisciplinaHasAluno;
    }

    public String getEstadoDisciplina() {
        return estadoDisciplina;
    }

    public void setEstadoDisciplina(String estadoDisciplina) {
        this.estadoDisciplina = estadoDisciplina;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /* @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDDisciplinaHasAluno != null ? IDDisciplinaHasAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaHasAluno)) {
            return false;
        }
        DisciplinaHasAluno other = (DisciplinaHasAluno) object;
        if ((this.IDDisciplinaHasAluno == null && other.IDDisciplinaHasAluno != null) || (this.IDDisciplinaHasAluno != null && !this.IDDisciplinaHasAluno.equals(other.IDDisciplinaHasAluno))) {
            return false;
        }
        return true;
    }*/
    @Override
    public String toString() {
        return "Model.DisciplinaHasAluno[ disciplinaHasAlunoPK=" + IDDisciplinaHasAluno + " ]";
    }

}
