package Model;

import Model.Professor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T16:26:03")
@StaticMetamodel(Enderecoprofessor.class)
public class Enderecoprofessor_ { 

    public static volatile SingularAttribute<Enderecoprofessor, String> estado;
    public static volatile SingularAttribute<Enderecoprofessor, String> cidade;
    public static volatile SingularAttribute<Enderecoprofessor, Integer> numero;
    public static volatile SingularAttribute<Enderecoprofessor, Professor> professorSiape;
    public static volatile SingularAttribute<Enderecoprofessor, Integer> idEndereco;
    public static volatile SingularAttribute<Enderecoprofessor, String> bairro;
    public static volatile SingularAttribute<Enderecoprofessor, String> rua;
    public static volatile SingularAttribute<Enderecoprofessor, Integer> cep;

}