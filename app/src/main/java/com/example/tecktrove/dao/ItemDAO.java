package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Item;

import java.util.ArrayList;
import java.util.List;

public interface ItemDAO {

    /**
     * Gets the item for some input number.
     *
     * @param serialNo  the input number
     * @return          the item
     */
    Item find(int serialNo);

    /**
     * Gets a list of all the items in the dao
     *
     * @return
     */
    ArrayList<Item> findAll();

    /**
     * Saves an object item in the dao
     *
     * @param entity    the item object
     */
    void save(Item entity);

    /**
     * Deletes the item object from the dao if it exists
     *
     * @param entity    an item object
     */
    void delete(Item entity);

    /**
     * Deletes the item object from the dao if it exists based on the serial number
     *
     * @param serialNo      the serial number of the item
     */
    void delete(int serialNo);

    /**
     * Deletes all the items from the dao
     */
    void deleteAll();

    /**
     * Returns the next available id that can be used for an item object
     *
     * @return  the next available number
     */
    int nextId();

}
