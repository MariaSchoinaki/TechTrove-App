package com.example.tecktrove.memorydao;

import com.example.tecktrove.dao.ItemDAO;
import com.example.tecktrove.domain.Item;

import java.util.ArrayList;

public class ItemDAOMemory implements ItemDAO {

    protected ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Gets the item for some input number.
     *
     * @param serialNo  the input number
     * @return          the item
     */
    @Override
    public Item find(int serialNo){
        for (Item item: items){
            if( item.getSerialNo() == serialNo){
                return item;
            }
        }
        return null;
    }

    /**
     * Gets a list of all the items in the dao
     *
     * @return
     */
    @Override
    public ArrayList<Item> findAll(){
        return new ArrayList<Item>(items);
    }

    /**
     * Saves an object item in the dao
     *
     * @param entity    the item object
     */
    @Override
    public void save(Item entity){
        items.add(entity);
    }

    /**
     * Deletes the item object from the dao if it exists
     *
     * @param entity    an item object
     */
    @Override
    public void delete(Item entity){
        items.remove(entity);
    }

    /**
     * Deletes the item object from the dao if it exists based on the serial number
     *
     * @param serialNo      the serial number of the item
     */
    @Override
    public void delete(int serialNo){
        items.remove(find(serialNo));
    }

    /**
     * Deletes all the items from the dao
     */
    @Override
    public void deleteAll(){
        items.clear();
    }

    /**
     * Returns the next available id that can be used for an item object
     *
     * @return  the next available number
     */
    @Override
    public int nextId(){
        return (items.size() > 0 ? items.get(items.size() - 1).getSerialNo() + 1 : 1);
    }
}
