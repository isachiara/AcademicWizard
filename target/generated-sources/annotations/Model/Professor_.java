package Model;

import Model.Disciplina;
import Model.Enderecoprofessor;
import Model.Telefoneprofessor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-13T23:48:16")
@StaticMetamodel(Professor.class)
public class Professor_ { 

    public static volatile SingularAttribute<Professor, String> senha;
    public static volatile ListAttribute<Professor, Telefoneprofessor> telefoneprofessorList;
    public static volatile SingularAttribute<Professor, String> siape;
    public static volatile SingularAttribute<Professor, String> curso;
    public static volatile ListAttribute<Professor, Disciplina> disciplinaList;
    public static volatile SingularAttribute<Professor, String> cpf;
    public static volatile SingularAttribute<Professor, Enderecoprofessor> enderecoprofessor;
    public static volatile SingularAttribute<Professor, String> nome;
    public static volatile SingularAttribute<Professor, String> sexo;

}