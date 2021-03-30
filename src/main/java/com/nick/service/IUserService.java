package com.nick.service;

import com.nick.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-28
 */
public interface IUserService extends IService<User> {

    public List<User> findAllUser();
}
