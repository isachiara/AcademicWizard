package Model;

import Model.DisciplinaHasAluno;
import Model.Professor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-13T23:48:16")
@StaticMetamodel(Disciplina.class)
public class Disciplina_ { 

    public static volatile ListAttribute<Disciplina, DisciplinaHasAluno> disciplinaHasAlunoList;
    public static volatile SingularAttribute<Disciplina, String> horario;
    public static volatile SingularAttribute<Disciplina, Integer> periodo;
    public static volatile SingularAttribute<Disciplina, Professor> professorSiape;
    public static volatile SingularAttribute<Disciplina, Integer> idDisciplina;
    public static volatile SingularAttribute<Disciplina, String> requisito;
    public static volatile SingularAttribute<Disciplina, String> dias;
    public static volatile SingularAttribute<Disciplina, String> nome;
    public static volatile SingularAttribute<Disciplina, String> cargaHoraria;

}