package cn.mytrip.service;

import cn.mytrip.beans.pojo.User;

import java.util.Date;

/**
 * token相关业务逻辑接口
 */
public interface TokenService {
    String SPERATOR="-";//拼接token的分隔符
    int MD5_USER_CODE_LENGTH=32;//用户编码MD5的加密长度
    int MD5_FEATURE_CODE_LENGTH=6;//特征码
    int TOKEN_TIME_OUT=7200;//pc默认时间存储2小时

    /**
     * 生成token
     * @param agent
     * @param user
     * @param date
     * @return
     */
    String generateToken(String agent, User user, Date date);
}
