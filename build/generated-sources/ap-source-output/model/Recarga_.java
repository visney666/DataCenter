package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Operador;
import model.RecargaPK;
import model.Vendedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-25T16:03:48")
@StaticMetamodel(Recarga.class)
public class Recarga_ { 

    public static volatile SingularAttribute<Recarga, Vendedor> vendedor;
    public static volatile SingularAttribute<Recarga, RecargaPK> recargaPK;
    public static volatile SingularAttribute<Recarga, Double> valor;
    public static volatile SingularAttribute<Recarga, Operador> operador;

}