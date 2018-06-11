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
@NamedQueries({
    @NamedQuery(name = "DisciplinaHasAluno.findAll", query = "SELECT d FROM DisciplinaHasAluno d")
    , @NamedQuery(name = "DisciplinaHasAluno.findByDisciplinaidDisciplina", query = "SELECT d FROM DisciplinaHasAluno d WHERE d.disciplinaHasAlunoPK.disciplinaidDisciplina = :disciplinaidDisciplina")
    , @NamedQuery(name = "DisciplinaHasAluno.findByAlunoMatricula", query = "SELECT d FROM DisciplinaHasAluno d WHERE d.disciplinaHasAlunoPK.alunoMatricula = :alunoMatricula")
    , @NamedQuery(name = "DisciplinaHasAluno.findByEstadoDisciplina", query = "SELECT d FROM DisciplinaHasAluno d WHERE d.estadoDisciplina = :estadoDisciplina")
    , @NamedQuery(name = "DisciplinaHasAluno.findByNota", query = "SELECT d FROM DisciplinaHasAluno d WHERE d.nota = :nota")})
public class DisciplinaHasAluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisciplinaHasAlunoPK disciplinaHasAlunoPK;
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

    public DisciplinaHasAluno(DisciplinaHasAlunoPK disciplinaHasAlunoPK) {
        this.disciplinaHasAlunoPK = disciplinaHasAlunoPK;
    }

    public DisciplinaHasAluno(DisciplinaHasAlunoPK disciplinaHasAlunoPK, String estadoDisciplina, float nota) {
        this.disciplinaHasAlunoPK = disciplinaHasAlunoPK;
        this.estadoDisciplina = estadoDisciplina;
        this.nota = nota;
    }

    public DisciplinaHasAluno(int disciplinaidDisciplina, int alunoMatricula) {
        this.disciplinaHasAlunoPK = new DisciplinaHasAlunoPK(disciplinaidDisciplina, alunoMatricula);
    }

    public DisciplinaHasAlunoPK getDisciplinaHasAlunoPK() {
        return disciplinaHasAlunoPK;
    }

    public void setDisciplinaHasAlunoPK(DisciplinaHasAlunoPK disciplinaHasAlunoPK) {
        this.disciplinaHasAlunoPK = disciplinaHasAlunoPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disciplinaHasAlunoPK != null ? disciplinaHasAlunoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaHasAluno)) {
            return false;
        }
        DisciplinaHasAluno other = (DisciplinaHasAluno) object;
        if ((this.disciplinaHasAlunoPK == null && other.disciplinaHasAlunoPK != null) || (this.disciplinaHasAlunoPK != null && !this.disciplinaHasAlunoPK.equals(other.disciplinaHasAlunoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.DisciplinaHasAluno[ disciplinaHasAlunoPK=" + disciplinaHasAlunoPK + " ]";
    }
    
}
