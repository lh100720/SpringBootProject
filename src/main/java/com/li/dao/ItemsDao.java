package com.li.dao;

import com.li.model.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsDao extends CrudRepository<Items, Integer> {

}