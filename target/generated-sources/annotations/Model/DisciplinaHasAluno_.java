package Model;

import Model.Aluno;
import Model.Disciplina;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-13T23:48:16")
@StaticMetamodel(DisciplinaHasAluno.class)
public class DisciplinaHasAluno_ { 

    public static volatile SingularAttribute<DisciplinaHasAluno, Aluno> aluno;
    public static volatile SingularAttribute<DisciplinaHasAluno, Disciplina> disciplina;
    public static volatile SingularAttribute<DisciplinaHasAluno, Integer> IDDisciplinaHasAluno;
    public static volatile SingularAttribute<DisciplinaHasAluno, Float> nota;
    public static volatile SingularAttribute<DisciplinaHasAluno, String> estadoDisciplina;

}