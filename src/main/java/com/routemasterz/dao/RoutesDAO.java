package com.routemasterz.dao;

import com.routemasterz.model.Route;

import java.util.List;

public interface RoutesDAO {
    void save(Route route);

    List<Route> findAllRoutesById(Long logisticianId);

    void removeRoute(Long routeId);
}
