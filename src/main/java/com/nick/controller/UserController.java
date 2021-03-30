package com.nick.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nick.common.vo.Result;
import com.nick.entity.User;
import com.nick.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-28
 */
@Api("用户信息")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @ApiOperation("查找Id")
    @GetMapping("/getUsers")
    public String getUsers(@RequestParam("id") int id){
        return  userService.getById(id).getName();
    }

    @ApiOperation("查找所有")
    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @ApiOperation("分页查询")
    @GetMapping("/getUsersByPage")
    public Result<?> getUsersByPage(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                    @RequestParam(name="pageSize", defaultValue="10") Integer pageSize){
        IPage<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> pageList = userService.page(page,wrapper);
        return Result.OK(pageList);
    }
}
