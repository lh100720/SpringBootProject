package com.li.service;

import com.li.dao.ItemsDao;
import com.li.model.Items;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by lihou on 2018/3/14.
 * 业务逻辑Service类
 */
@Transactional
@Service
public class ItemsService {

    @Resource
    public ItemsDao itemsDao;

    /**
     * 新增对象
     * @param items
     */
    @Transactional
    public void save(Items items){
        itemsDao.save( items);
    }

    /**
     * 根据id删除对象
     * @param id
     */
    @Transactional
    public void delete(Integer id){
        itemsDao.deleteById(id);
    }
    /**
     * 查询数据
     * @return
     */
    public Iterable<Items> getAll(){
        return itemsDao.findAll();
    }

    /**
     * 修改用户对象数据
     * @param items
     */
    @Transactional
    public void update(Items items){
        // 先根据要修改的对象id查询出对应的持久化对象

        Optional<Items> sessionItems= itemsDao.findById(items.getId());

        // 直接调用持久化对象的set方法修改对象的数据
        Items items2 =  sessionItems.get();
        items2.setDetails(items.getDetails());
    }
}
