package com.liaojw.ssm.service.impl;

import com.liaojw.ssm.dao.UserMapper;
import com.liaojw.ssm.model.User;
import com.liaojw.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LJW on 2017/3/29.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(User user) {
        return userMapper.selectOne(user);
    }
}
