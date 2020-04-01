package com.routeapp.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface RouteRepository extends CrudRepository<Route, Long>,
        QueryByExampleExecutor<Route>, JpaSpecificationExecutor<Route> {

    Page<Route> findAllByOrderByDateDesc(Pageable pageable);

    Page<Route> findAllByOrderByMarkAsc(Pageable pageable);

    Page<Route> findAllByOrderByScopeAsc(Pageable pageable);

    Page<Route> findAllByOrderByYearAsc(Pageable pageable);

    Page<Route> findAllByOrderByMileageAsc(Pageable pageable);

    Page<Route> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Route> findAllByMark(String mark, Pageable pageable);

    Page<Route> findAll(Specification<Route> spec, Pageable pageable);

}



