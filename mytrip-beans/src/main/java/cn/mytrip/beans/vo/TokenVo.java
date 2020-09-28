package cn.mytrip.beans.vo;

import java.io.Serializable;

/**
 * 视图对象
 */
public class TokenVo  implements Serializable {
         private String token;//令牌
         private Long gentime;//产生时间
         private Long expireTime;//过期时间
    public TokenVo(){

    }

    public TokenVo(String token, Long gentime, Long expireTime) {
        this.token = token;
        this.gentime = gentime;
        this.expireTime = expireTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGentime() {
        return gentime;
    }

    public void setGentime(Long gentime) {
        this.gentime = gentime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

}
