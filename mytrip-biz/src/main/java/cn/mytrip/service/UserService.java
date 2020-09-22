package cn.mytrip.service;

import cn.mytrip.beans.pojo.User;
import cn.mytrip.common.Page;

public interface UserService {
    /**
     * 分页查询用户
     * @param pageIndex
     * @param pageSize
     * @param userName
     * @return
     */
    Page<User> getPagedUsers(int pageIndex, int pageSize, String userName);
}
