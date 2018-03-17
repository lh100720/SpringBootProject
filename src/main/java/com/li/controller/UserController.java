package com.li.controller;

import com.li.model.User;
import com.li.service.UserService;
import io.swagger.annotations.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lihou on 2018/3/14.
 * 对用户进行CRUD操作的Controller类
 */

//@RestController注解能够使项目支持Rest
@RestController
//表示只有角色是ADMIN的管理员才可以查看，普通用户查看不了--权限管理
@PreAuthorize("hasRole('ROLE_ADMIN')")
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/springboot")
@Api(value = "后台用户相关api", description = "后台用户相关api")
public class UserController {
        @Resource
        UserService userService ;
        //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
        @RequestMapping(value = "/getUser", method = RequestMethod.GET)
        //通过用户名查找用户的操作
        @ApiOperation(value = "获取用户信息", notes = "获取所有用户的信息")
        @ApiResponses(value = {
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 400, message = "No user Provided"),
        })
        Iterable<User> getAll(){
                return userService.getAll();
        }
        //添加用户的操作
        @ApiOperation(value = "添加用户信息", notes = "新增一个用户信息")
        @ApiResponses(value = {
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 400, message = "No user Provided"),
        })
        @RequestMapping(value = "/save", method = RequestMethod.GET)
        String saveUser(){
                User user = new User();
                user.setUserName("Alla");
                user.setAge( 22 );
                user.setPassword( 234567 );
                userService.save( user );
                return "新增数据成功";
        }
        //删除用户的操作
        @ApiOperation(value = "删除用户信息", notes = "删除某一用户的信息")
        @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer")
        @ApiResponses(value = {
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 400, message = "No user Provided"),
        })
        @RequestMapping(value = "/delete", method = RequestMethod.GET)
        String deleteUser(){
                userService.delete(1);
                return "删除数据成功";
        }
        //更新用户的操作
        @ApiOperation(value = "更新用户信息", notes = "更新某一用户的信息")
        @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
        @ApiResponses(value = {
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 400, message = "No user Provided"),
        })
        @RequestMapping(value = "/update", method = RequestMethod.GET)
        String updateUser(){
                User user =new User();
                user.setId(1);
                user.setUserName("孙悟空");
                userService.update(user);
                return"修改成功!";
        }

    }

