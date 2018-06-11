/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Henrique
 */
@Embeddable
public class DisciplinaHasAlunoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Disciplina_idDisciplina")
    private int disciplinaidDisciplina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Aluno_Matricula")
    private int alunoMatricula;

    public DisciplinaHasAlunoPK() {
    }

    public DisciplinaHasAlunoPK(int disciplinaidDisciplina, int alunoMatricula) {
        this.disciplinaidDisciplina = disciplinaidDisciplina;
        this.alunoMatricula = alunoMatricula;
    }

    public int getDisciplinaidDisciplina() {
        return disciplinaidDisciplina;
    }

    public void setDisciplinaidDisciplina(int disciplinaidDisciplina) {
        this.disciplinaidDisciplina = disciplinaidDisciplina;
    }

    public int getAlunoMatricula() {
        return alunoMatricula;
    }

    public void setAlunoMatricula(int alunoMatricula) {
        this.alunoMatricula = alunoMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) disciplinaidDisciplina;
        hash += (int) alunoMatricula;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaHasAlunoPK)) {
            return false;
        }
        DisciplinaHasAlunoPK other = (DisciplinaHasAlunoPK) object;
        if (this.disciplinaidDisciplina != other.disciplinaidDisciplina) {
            return false;
        }
        if (this.alunoMatricula != other.alunoMatricula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.DisciplinaHasAlunoPK[ disciplinaidDisciplina=" + disciplinaidDisciplina + ", alunoMatricula=" + alunoMatricula + " ]";
    }
    
}
