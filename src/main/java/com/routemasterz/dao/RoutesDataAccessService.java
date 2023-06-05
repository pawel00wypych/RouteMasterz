package com.routemasterz.dao;

import com.routemasterz.model.Route;
import com.routemasterz.repository.RoutesRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("routesJPA")
public class RoutesDataAccessService implements RoutesDAO{

    private final RoutesRepository repository;

    public RoutesDataAccessService(RoutesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Route route) {
        repository.save(route);
    }

    @Override
    public List<Route> findAllRoutesById(Long logisticianId) {
        return repository.findAllRoutesById(logisticianId);
    }

    @Override
    public void removeRoute(Long routeId) {
        repository.removeRouteById(routeId);
    }
}
