package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Component;
import java.util.ArrayList;
import com.example.tecktrove.util.Port;

public interface ComponentDAO {
     /**
      * Function that returns the entire
      * component list
      *
      * @return  the components
      */
     ArrayList<Component> findAll();
     /**
      * Function that returns all
      * the components witch has
      * the given manufacturer defined
      * by the user
      *
      * @return  the manufacturers
      */
     ArrayList<Component> findByManufacturer(String manufacturer);
     /**
      * Function that returns all
      * the components witch has
      * the given required ports defined
      * by the user
      *
      * @return  the required
      */
     ArrayList<Component> findAllByRequiredPorts(Port ports);
     /**
      * Function that returns all
      * the components witch has
      * the given available ports defined
      * by the user
      *
      * @return  the available
      */
     ArrayList<Component> findAllByAvailablePorts(Port ports);
     /**
      * Function that deletes the
      * given component
      */
     void delete(Component component);
     /**
      * Function that deletes all
      * the components
      */
     void deleteAll();
     /**
      * Function that deletes all
      * the components with the
      * given available ports
      */
     void deleteByAvailablePorts(Port ports);
     /**
      * Function that deletes all
      * the components with the
      * given required ports
      */
     void deleteByRequiredPorts(Port ports);
     /**
      * Function that deletes all
      * the components with the
      * given manufacturer
      */
     void deleteByManufacturer(String manufacturer);
     /**
      * Function that saves the
      * given component
      */
     void save(Component component);
}