package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Component;
import java.util.ArrayList;
import com.example.tecktrove.util.Port;

public interface ComponentDAO {

     /**
      * Stores the component in the dao
      *
      * @param component the component
      */
     void save(Component component);

     /**
      * Returns all the components in the dao.
      *
      * @return new ArrayList with the components
      */
     ArrayList<Component> findAll();

     /**
      * Finds a component by its name
      *
      * @param name the component's name
      * @return     a Component object or null
      */
     Component find(String name);

     /**
      * Finds a component by its model number
      *
      * @param modelNo component's model number
      * @return     a Component object or null
      */
     Component find(int modelNo);

     /**
      * Returns all the components made by
      * the given manufacturer
      *
      * @param manufacturer the manufacturer
      * @return ArrayList with the components or null
      */
     ArrayList<Component> findByManufacturer(String manufacturer);

     /**
      * Returns all the components which have
      * the given required ports.
      *
      * @param ports the required ports
      * @return     Arraylist with the components or null
      */
     ArrayList<Component> findAllByRequiredPorts(Port ports);


     /**
      * Returns all the components which have
      * the given available ports.
      *
      * @param ports the available ports
      * @return  Arraylist with the components or null
      */
     ArrayList<Component> findAllByAvailablePorts(Port ports);

     /**
      * Deletes the given component
      *
      * @param component the component
      */
     void delete(Component component);

     /**
      * Deletes a component based on their name
      *
      * @param name the name of the component
      */
     void delete(String name);

     /**
      * Deletes a component based on the model number
      *
      * @param modelNo the model number
      */
     void delete(int modelNo);

     /**
      * Function that deletes all
      * the components in the dao
      */
     void deleteAll();

     /**
      * Deletes all the components which have the
      * given available ports
      *
      * @param ports the available ports
      */
     void deleteByAvailablePorts(Port ports);

     /**
      * Deletes all the components which have the
      * given required ports
      *
      * @param ports the required ports
      */
     void deleteByRequiredPorts(Port ports);

     /**
      * Deletes all the components made by
      * given manufacturer
      *
      * @param manufacturer the manufacturer
      */
     void deleteByManufacturer(String manufacturer);
}