package cn.mytrip.controller;

import cn.mytrip.beans.dto.Dto;
import cn.mytrip.beans.pojo.User;
import cn.mytrip.beans.vo.TokenVo;
import cn.mytrip.common.DtoErrorCode;
import cn.mytrip.common.DtoUtil;
import cn.mytrip.common.RedisUtil;
import cn.mytrip.service.AccountService;
import cn.mytrip.service.TokenService;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 账号相关的控制器
 */
@RestController
public class AccountController {
    @Resource
    AccountService accountService;
    @Resource
    TokenService tokenService;

    @RequestMapping(value="/login",method= RequestMethod.POST,produces = {"application/json;characterEncoding=UTF-8"})
    public Dto doLogin(@RequestParam("name") String name,
                       @RequestParam("pwd") String pwd,
                       HttpServletRequest request){
        //验证用户名密码是否正确
        User user=accountService.checkLogin(name,pwd);
        if(user!=null){
            //获取请求头
            String agent = request.getHeader("User-Agent");
            //当前系统时间
            Date date = new Date();
            //如果正确，则生成token 存入redis 返回正确结果
            String token = tokenService.generateToken(agent,user,date);
            System.out.println(token);
            //存入redis
            if(token.startsWith("token:pc")){
                //pc有时间限制
                String s= RedisUtil.set(token,TokenService.TOKEN_TIME_OUT, JSON.toJSONString(user));
                System.out.println(s);
            }else{
                //mobile无时间限制
                RedisUtil.set(token, JSON.toJSONString(user));
            }
            // 返回正确结果
            TokenVo tokenvo=new TokenVo(token,date.getTime(),date.getTime()+tokenService.TOKEN_TIME_OUT*1000);
            return DtoUtil.returnSuccess("登陆成功",tokenvo);
        }else{
            return DtoUtil.returnFail("用户名或密码错误",DtoErrorCode.AUTH_LOGIN_DENY);
            //错误则返回登陆页面
        }
    }
}
