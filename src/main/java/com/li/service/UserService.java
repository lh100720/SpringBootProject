package com.li.service;

import com.li.dao.UserDao;
import com.li.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by lihou on 2018/3/14.
 * 业务逻辑Service类
 */
@Service
public class UserService {

    @Resource
    public UserDao userDao;
    /**
     * 新增对象
     * @param user
     */
    @Transactional
    public void save(User user){
        userDao.save( user);
    }
    /**
     * 根据id删除对象
     * @param id
     */
    @Transactional
    public void delete(Integer id){
        userDao.deleteById(id);
    }
    /**
     * 查询数据
     *
     * @return
     */
    public Iterable<User> getAll(){
        return userDao.findAll();
    }

    /**
     * 修改用户对象数据
     * @param user
     */
    @Transactional
    public void update(User user){
        // 先根据要修改的对象id查询出对应的持久化对象

        Optional<User> sessionUser = userDao.findById(user.getId());

        // 直接调用持久化对象的set方法修改对象的数据
         User user2 =  sessionUser.get();
         user2.setUserName(user.getUserName());
    }
}
