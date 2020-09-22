package cn.mytrip.service.impl;

import cn.mytrip.beans.pojo.User;
import cn.mytrip.common.Page;
import cn.mytrip.dao.UserMapper;
import cn.mytrip.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public Page<User> getPagedUsers(int pageIndex, int pageSize, String userName) {
        Map<String,Object> params = new HashMap<>();
        params.put("userName",userName);
        params.put("from",(pageIndex-1)*pageSize);
        params.put("limit",pageSize);
        Integer totalCount = userMapper.getUserCountByWord(params);
        List<User> data = userMapper.getUsersByWord(params);
        Page<User> page = new Page<User>(pageIndex,pageSize,totalCount,data);
        return page;
    }
}
