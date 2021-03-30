package com.nick.mapper;

import com.nick.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-28
 */
public interface UserMapper extends BaseMapper<User> {
    public List<User> findAllUser();
}
