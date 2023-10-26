package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Recarga;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-25T16:03:48")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, String> cedula;
    public static volatile SingularAttribute<Vendedor, Integer> vendedorId;
    public static volatile SingularAttribute<Vendedor, String> nombre;
    public static volatile CollectionAttribute<Vendedor, Recarga> recargaCollection;

}