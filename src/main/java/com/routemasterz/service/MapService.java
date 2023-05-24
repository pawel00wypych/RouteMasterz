package com.routemasterz.service;

import com.routemasterz.dao.CheckpointsDAO;
import com.routemasterz.dao.RoutesDAO;
import com.routemasterz.dto.CheckpointDTO;
import com.routemasterz.dto.SaveRouteRequest;
import com.routemasterz.dto.SetPlaceRequest;
import com.routemasterz.model.Checkpoint;
import com.routemasterz.model.Route;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class MapService {

    private final RoutesDAO routesDAO;
    private final CheckpointsDAO checkpointsDAO;

    public MapService(@Qualifier("routesJPA") RoutesDAO routesDAO,
                      @Qualifier("checkpointsJPA") CheckpointsDAO checkpointsDAO) {
        this.routesDAO = routesDAO;
        this.checkpointsDAO = checkpointsDAO;
    }


    public String setPlace(SetPlaceRequest request) {
        return "place set";
    }

    public ResponseEntity<?> saveRoute(SaveRouteRequest request) {
        try {
            List<Checkpoint> checkpoints = new LinkedList<>();
            Route route = new Route(request.routeName(), LocalDate.now().toString());
            int i = 0;
            routesDAO.save(route);

            for (CheckpointDTO checkpoint : request.checkpoints()) {
                Checkpoint check = new Checkpoint(route,
                        checkpoint.country(),
                        checkpoint.street(),
                        checkpoint.city(),
                        checkpoint.state(),
                        checkpoint.postalcode(),
                        checkpoint.hour(),
                        i++);
                checkpoints.add(check);
                checkpointsDAO.saveCheckpoint(check);
            }



        }catch (Exception e) {
            return new ResponseEntity<>("Route save Exception: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Route saved", HttpStatus.OK);
    }
}
