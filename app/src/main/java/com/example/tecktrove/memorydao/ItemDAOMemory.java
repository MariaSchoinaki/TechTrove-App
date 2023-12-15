package com.example.tecktrove.memorydao;

import com.example.tecktrove.dao.ItemDAO;
import com.example.tecktrove.domain.Item;

import java.util.ArrayList;

public class ItemDAOMemory implements ItemDAO {

    protected ArrayList<Item> items = new ArrayList<Item>();

    @Override
    public Item find(int serialNo){
        for (Item item: items){
            if( item.getSerialNo() == serialNo){
                return item;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Item> findAll(){
        return new ArrayList<Item>(items);
    }

    @Override
    public void save(Item entity){
        items.add(entity);
    }

    @Override
    public void delete(Item entity){
        items.remove(entity);
    }

    @Override
    public void delete(int serialNo){
        items.remove(find(serialNo));
    }

    @Override
    public void deleteAll(){
        items.clear();
    }

    @Override
    public int nextId(){
        return (items.size() > 0 ? items.get(items.size() - 1).getSerialNo() + 1 : 1);
    }
}
