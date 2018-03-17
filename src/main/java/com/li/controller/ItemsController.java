package com.li.controller;

import com.li.model.Items;
import com.li.service.ItemsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lihou on 2018/3/14.
 * 对产品进行CRUD操作的Controller类
 */

//@RestController注解能够使项目支持Rest
@RestController
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/springboot2")
public class ItemsController {
    @Resource
    ItemsService itemsService ;

        //根据id查找商品的方法
       @RequestMapping(value = "/getItems", method = RequestMethod.GET)
       @ApiOperation(value = "获取商品信息", notes = "获取所有商品的信息")
       @ApiResponses(value = {
               @ApiResponse(code = 404, message = "Not Found"),
               @ApiResponse(code = 400, message = "No user Provided"),
       })
       Iterable<Items> getItems(){
           return itemsService.getAll();
       }

        //添加产品的操作
        @RequestMapping(value = "/saveItem", method = RequestMethod.GET)
        @ApiOperation(value = "添加商品信息", notes = "新增一个商品信息")
        @ApiResponses(value = {
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 400, message = "No user Provided"),
        })
        String saveItems(){
            Items items  = new Items();
            items.setItemName("ippad");
            //items.setId( 56 );
            items.setDetails( "应用广泛" );
            itemsService.save( items );
            return "新增数据成功";
        }
        //删除产品的操作
        @RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
        @ApiOperation(value = "删除用户信息", notes = "删除某一用户的信息")
        @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer")
        @ApiResponses(value = {
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 400, message = "No user Provided"),
        })
        String deleteItem(){
            itemsService.delete(1);
            return "删除数据成功";
        }
        //更新产品的操作
        @RequestMapping(value = "/update", method = RequestMethod.GET)
        @ApiOperation(value = "更新用户信息", notes = "更新某一用户的信息")
        @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
        @ApiResponses(value = {
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 400, message = "No user Provided"),
        })
        String updateItem(){
            Items items  =new Items();
            items.setId(1);
            items.setDetails("真麻烦");
            itemsService.update(items);
            return"修改成功!";
        }

    }

