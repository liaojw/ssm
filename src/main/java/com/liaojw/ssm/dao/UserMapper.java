package com.liaojw.ssm.dao;

import com.liaojw.ssm.model.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserMapper extends Mapper<User> {

}