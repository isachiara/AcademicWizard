package Model;

import Model.DisciplinaHasAluno;
import Model.Enderecoaluno;
import Model.Telefonealuno;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T16:26:03")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile ListAttribute<Aluno, DisciplinaHasAluno> disciplinaHasAlunoList;
    public static volatile SingularAttribute<Aluno, String> senha;
    public static volatile ListAttribute<Aluno, Telefonealuno> telefonealunoList;
    public static volatile SingularAttribute<Aluno, String> curso;
    public static volatile SingularAttribute<Aluno, String> matricula;
    public static volatile SingularAttribute<Aluno, String> cpf;
    public static volatile SingularAttribute<Aluno, String> nome;
    public static volatile ListAttribute<Aluno, Enderecoaluno> enderecoalunoList;
    public static volatile SingularAttribute<Aluno, String> sexo;

}