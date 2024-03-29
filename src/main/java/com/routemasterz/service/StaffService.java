package com.routemasterz.service;

import com.routemasterz.dao.CheckpointsDAO;
import com.routemasterz.dao.RoutesDAO;
import com.routemasterz.dao.UserDAO;
import com.routemasterz.dao.UserDetailsDAO;
import com.routemasterz.dto.*;
import com.routemasterz.model.*;
import com.routemasterz.util.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class StaffService {
    private final RoutesDAO routesDAO;
    private final JWTUtil jwtUtil;
    private final UserDAO userDAO;
    private final CheckpointsDAO checkpointsDAO;
    private final UserDetailsDAO userDetailsDAO;

    Logger logger = LoggerFactory.getLogger(StaffService.class);
    public StaffService(@Qualifier("routesJPA") RoutesDAO routesDAO,
                        JWTUtil jwtUtil,
                        @Qualifier("jpa") UserDAO userDAO,
                        @Qualifier("checkpointsJPA") CheckpointsDAO checkpointsDAO,
                        @Qualifier("userDetailsJpa") UserDetailsDAO userDetailsDAO) {
        this.routesDAO = routesDAO;
        this.jwtUtil = jwtUtil;
        this.userDAO = userDAO;
        this.checkpointsDAO = checkpointsDAO;
        this.userDetailsDAO = userDetailsDAO;
    }

    public ResponseEntity<?> changeUserRole(UserRoleRequest request) {
        try {

            if(!request.newRole().equals("LOGISTICIAN") &&
                    !request.newRole().equals("DRIVER") &&
                    !request.newRole().equals("ADMIN"))
                return new ResponseEntity<>("Wrong Role!", HttpStatus.BAD_REQUEST);

            userDAO.changeUserRole(request.userId(), request.newRole());
            return new ResponseEntity<>("role changed", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> showRoutes(ShowRoutesRequest request) {
        try {
            String email = jwtUtil.getSubject(request.token());
            UserEntity user = userDAO.findUserByEmail(email);
            logger.warn("user: "+user.getEmail());
            List<Route> routes = routesDAO.findAllRoutesById(user.getId());
            logger.warn("routes: "+routes);
            List<RouteDTO> routesDTO = new ArrayList<>();
            for(Route route: routes){
                logger.warn("route: "+route);
                logger.warn("route: "+route.getName());

                List<Checkpoint> checkpoints = checkpointsDAO.findCheckpointsByRouteId(route.getId());
                logger.warn("checkpoints: "+checkpoints);

                routesDTO.add(new RouteDTO(route.getId(),
                        route.getName(),
                        checkpoints));

                logger.warn("routesDTO: "+routesDTO);

            }

            logger.warn("routesDTO2: "+routesDTO);
            return new ResponseEntity<>(routesDTO, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> deleteRoute(DeleteRouteRequest request) {
        try {
            routesDAO.removeRoute(request.routeId());
            return new ResponseEntity<>("route deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> showAllUsers() {
        try {
            List<ExtendedUserDetailsDTO> list = new LinkedList<>();
            List<UserEntity> users = userDAO.getAllNonAdminUsers();
            UserEntityDetails userInfo;

            for(UserEntity user: users){
                userInfo = userDetailsDAO.findUserInfoByEmail(user.getEmail());
                list.add(new ExtendedUserDetailsDTO(user.getId(),
                        userInfo.getName(),
                        userInfo.getSurname(),
                        user.getEmail(),
                        userInfo.getPhoneNumber(),
                        user.getRole()));
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> changeUserCompany(UserCompanyRequest request) {
        try {
            userDAO.changeUserCompany(request.userId(), request.company());
            return new ResponseEntity<>("company changed", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
