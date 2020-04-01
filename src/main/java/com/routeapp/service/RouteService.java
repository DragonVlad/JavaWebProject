package com.routeapp.service;

import com.routeapp.entity.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RouteService {

    Page<Route> findAllByOrderByDateDesc(Pageable pageable);

    Page<Route> findAllByOrderByMarkAsc(Pageable pageable);

    Page<Route> findAllByOrderByScopeAsc(Pageable pageable);

    Page<Route> findAllByOrderByYearAsc(Pageable pageable);

    Page<Route> findAllByOrderByMileageAsc(Pageable pageable);

    Page<Route> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Route> findAllByMark(String mark, Pageable pageable);

    Page<Route> findBy(String search, Pageable pageable);

    abstract Route getRouteById(Long id);

    Route saveRoute(Route route);

    void deleteRoute(Long id);
}
