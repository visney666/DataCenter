package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Recarga;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-25T16:03:48")
@StaticMetamodel(Operador.class)
public class Operador_ { 

    public static volatile SingularAttribute<Operador, String> nombre;
    public static volatile SingularAttribute<Operador, Integer> operadorId;
    public static volatile CollectionAttribute<Operador, Recarga> recargaCollection;

}