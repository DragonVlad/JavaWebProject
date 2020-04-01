package com.routeapp.entity;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public final class RouteSpecifications {
    public static Specification<Route> inPlaceOrOutPlace(final String search) {
        return (root, query, builder) -> {
            String content = getContainsLikePattern(search);
            Predicate inPlacePredicate = builder.like(builder.lower(root.get(Route_.inPlace)), content);
            Predicate outPlacePredicate = builder.like(builder.lower(root.get(Route_.outPlace)), content);
            return builder.or(inPlacePredicate, outPlacePredicate);
        };
    }

    public static Specification<Route> idOrDate(final Integer searchInt) {
        return (root, query, builder) -> {
            Predicate idPredicate = builder.equal(root.get(Route_.id), searchInt);
            Predicate datePredicate = builder.equal(root.get(Route_.date), searchInt);
            return builder.or(idPredicate, datePredicate);
        };
    }

    private static String getContainsLikePattern(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        } else {
            return "%" + searchTerm.toLowerCase() + "%";
        }
    }
}
