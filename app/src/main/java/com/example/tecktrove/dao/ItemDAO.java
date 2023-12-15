package com.example.tecktrove.dao;

import com.example.tecktrove.domain.Item;

import java.util.ArrayList;
import java.util.List;

public interface ItemDAO {

    Item find(int serialNo);

    ArrayList<Item> findAll();

    void save(Item entity);

    void delete(Item entity);

    void delete(int serialNo);

    void deleteAll();

    int nextId();

}
