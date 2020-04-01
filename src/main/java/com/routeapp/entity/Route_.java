package com.routeapp.entity;

import javax.persistence.metamodel.SingularAttribute;
import java.sql.Date;

@javax.persistence.metamodel.StaticMetamodel(com.routeapp.entity.Route.class)
public class Route_ {
    public static volatile SingularAttribute<Route, Long> id;
    public static volatile SingularAttribute<Route, String> outPlace;
    public static volatile SingularAttribute<Route, String> inPlace;
    public static volatile SingularAttribute<Route, Date> date;
}
