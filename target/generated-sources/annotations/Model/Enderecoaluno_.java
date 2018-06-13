package Model;

import Model.Aluno;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-12T22:03:54")
@StaticMetamodel(Enderecoaluno.class)
public class Enderecoaluno_ { 

    public static volatile SingularAttribute<Enderecoaluno, String> estado;
    public static volatile SingularAttribute<Enderecoaluno, String> cidade;
    public static volatile SingularAttribute<Enderecoaluno, Aluno> aluno;
    public static volatile SingularAttribute<Enderecoaluno, String> numero;
    public static volatile SingularAttribute<Enderecoaluno, Integer> idEndereco;
    public static volatile SingularAttribute<Enderecoaluno, String> bairro;
    public static volatile SingularAttribute<Enderecoaluno, String> rua;
    public static volatile SingularAttribute<Enderecoaluno, String> cep;

}