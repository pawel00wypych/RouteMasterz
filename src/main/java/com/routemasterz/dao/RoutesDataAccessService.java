package com.routemasterz.dao;

import com.routemasterz.model.Route;
import com.routemasterz.repository.RoutesRepository;
import org.springframework.stereotype.Repository;

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
}
