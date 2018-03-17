package com.li.dao;

import com.li.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/3/14.
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

}