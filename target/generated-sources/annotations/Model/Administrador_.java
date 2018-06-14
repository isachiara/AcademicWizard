package Model;

import Model.Telefoneadministrador;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-13T23:48:16")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, String> senha;
    public static volatile SingularAttribute<Administrador, Integer> idAdministrador;
    public static volatile ListAttribute<Administrador, Telefoneadministrador> telefoneadministradorList;
    public static volatile SingularAttribute<Administrador, String> nome;
    public static volatile SingularAttribute<Administrador, String> usuario;

}