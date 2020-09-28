package cn.mytrip.service;

import cn.mytrip.beans.pojo.User;

/**
 * 账号相关的业务逻辑接口
 */
public interface AccountService {
    /**
     * 验证登陆
     * @param userCode
     * @param userPassword
     * @return
     */
    User checkLogin(String userCode,String userPassword);
}
