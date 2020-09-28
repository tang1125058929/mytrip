package cn.mytrip.service.impl;

import cn.mytrip.beans.pojo.User;
import cn.mytrip.common.MD5Util;
import cn.mytrip.common.UserAgentUtil;
import cn.mytrip.service.TokenService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String generateToken(String agent, User user, Date date) {
        //根据user-agent判断客户端类型
        //拼接token
        StringBuffer token=new StringBuffer("token:");
        String deviceType = UserAgentUtil.getDeviceType(agent);
        if(deviceType.equals("Personal computer")){
            //pc
            token.append("pc");

        }else if(deviceType.equals("unKnown")){
            if(UserAgentUtil.isMobile(agent)){
                //mobile
                token.append("mobile");
            }else{
                //pc
                token.append("pc");
            }
        }else{
            //mobile
            token.append("mobile");
        }
        token.append(SPERATOR);
        token.append(MD5Util.getMd5(user.getUserCode(),TokenService.MD5_USER_CODE_LENGTH));
        token.append(TokenService.SPERATOR);
        token.append(user.getId());
        token.append(TokenService.SPERATOR);
        token.append(new SimpleDateFormat("yyyyMMddHHmmss").format(date));
        token.append(TokenService.SPERATOR);
       token.append(MD5Util.getMd5(agent,TokenService.MD5_FEATURE_CODE_LENGTH));
        return token.toString();
    }
}
