package cn.mytrip.service.impl;

import cn.mytrip.beans.pojo.User;
import cn.mytrip.dao.UserMapper;
import cn.mytrip.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    UserMapper userMapper;
    @Override
    public User checkLogin(String userCode, String userPassword) {
        User user=userMapper.getUserByUserCode(userCode);
        if(user!=null && user.getUserPassword().equals(userPassword)){
            return user;
        }
        return null;
    }
}
