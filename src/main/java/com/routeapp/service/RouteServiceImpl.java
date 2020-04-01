package com.routeapp.service;

import com.routeapp.entity.RouteRepository;
import com.routeapp.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.routeapp.entity.RouteSpecifications.inPlaceOrOutPlace;
import static com.routeapp.entity.RouteSpecifications.idOrDate;

@Transactional
@Service
public abstract class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;

    @Autowired
    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Page<Route> findAllByOrderByInPlaceAsc(Pageable pageable) {
        return routeRepository.findAllByOrderByMarkAsc(pageable);
    }

    public Page<Route> findAllByOrderByDateAsc(Pageable pageable) {
        return routeRepository.findAllByOrderByYearAsc(pageable);
    }

    public Page<Route> findAllByOrderByIdAsc(Pageable pageable) {
        return routeRepository.findAllByOrderByMileageAsc(pageable);
    }

    public Page<Route> findAllByOutPlace(String mark, Pageable pageable) {
        return routeRepository.findAllByMark(mark, pageable);
    }

    @Override
    public Page<Route> findBy(String search, Pageable pageable) {
        Specification<Route> searchResult;
        if (search.matches("[-+]?\\d+")) {
            searchResult = idOrDate(Integer.valueOf(search));
        } else
            searchResult = inPlaceOrOutPlace(search);
        return routeRepository.findAll(searchResult, pageable);
    }

    @Override
    public Page<Route> findAllByOrderByDateDesc(Pageable pageable) {
        return routeRepository.findAllByOrderByDateDesc(pageable);
    }

    @Override
    public Route getRouteById(Long id) {
        return routeRepository.findOne(id);
    }

    @Override
    public void deleteRoute(Long id) {
        routeRepository.delete(id);
    }
}
